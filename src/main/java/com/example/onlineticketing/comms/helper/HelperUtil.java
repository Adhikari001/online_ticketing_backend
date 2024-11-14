package com.example.onlineticketing.comms.helper;

import com.example.onlineticketing.comms.exceptionhandler.RestException;
import com.example.onlineticketing.entity.EntityBaseClass;
import com.example.onlineticketing.entity.person.Person;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class HelperUtil {
    public static LocalDate toLocalDate(String date) {
        if (date == null || date.isEmpty())
            return null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(date, dateTimeFormatter);
        } catch (Exception e) {
            log.error("Date format Invalid. Couldn't parse to LocalDate");
            throw new RestException("HU001", e.getMessage());
        }
    }

    public static LocalDateTime toLocalDateTime(String stringDate) {
        if (stringDate == null)
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(stringDate, formatter);
        } catch (Exception e) {
            log.error("Date format Invalid. Couldn't parse to LocalDateTime");
            throw new RestException("HU004", e.getMessage());
        }
    }

    public static LocalDateTime getLocalDateTimeOfUTC() {
        // return LocalDateTime.now();
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
    }

    public static LocalDate getLocalDateOfUTC() {
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();
    }

    public static String generateNumeric(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    // 2000 = rs 20.00
    public static String formatNepaliCurrency(String amount) {
        boolean addMinus = amount.startsWith("-");
        if (addMinus) {
            amount = amount.substring(1);
        }
        if (amount.isEmpty()) {
            amount = "000";
        } else if (amount.length() == 1) {
            amount = "00".concat(amount);
        } else if (amount.length() == 2) {
            amount = "0".concat(amount);
        }
        return "Rs ".concat(addMinus ? "-" : "").concat(amount.substring(0, amount.length() - 2)).concat(".")
                .concat(amount.substring(amount.length() - 2));
    }

    public static String formatNepaliCurrency(Long amount) {
        if (amount == null)
            return formatNepaliCurrency(String.valueOf(0));
        return formatNepaliCurrency(String.valueOf(amount));
    }

    public static String getFullName(String firstName, String lastName) {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }

    public static void main(String[] args) {

        printStringAroundThePosition("select new com.example.onlineticketing.dto.visit.VisitBaseResponse( " +
                "       v.id, v.visitDateTime, v.visitRemarks, v.involvedTooth, v.visitStatus, " +
                "       v.appointment.patient.id, v.appointment.patient.fullName, v.appointment.patient.phoneNumber, " +
                "       case when doc != null then doc.id else null end, " +
                "       case when doc != null then doc.firstName else null end, " +
                "       case when doc != null then doc.lastName else null end, " +
                "       v.appointment.id)" +
                "   from Visit v " +
                "   left join Doctor doc on v.assignedDoctor = doc" +
                "   where v.visitDateTime >= :from and v.visitDateTime< :to " +
                "   and (cast(:doctorId as uuid ) is null or v.assignedDoctor.id = :doctorId) " +
                "   order by v.visitDateTime asc ", 277, 15);

    }

    public static void printStringAroundThePosition(String value, int position, int displacement) {
        System.out.println(value.substring(position - displacement, position + displacement));
        System.out.println(value.substring(position - 1, position + 1));
    }

    public static String stringFromArrayOfNumbers(List<String> listOfString) {
        if (listOfString == null || listOfString.isEmpty())
            return "";
        List<String> strinngList = listOfString.stream().filter(s -> s.matches("^[0-9]+")).toList();
        return String.join(",", strinngList);
    }

    public static Long[] stringToArrayOfNumbers(String listOfString) {
        if (listOfString == null || listOfString.isEmpty())
            return new Long[0];
        return Arrays.stream(listOfString.split(",")).filter(s -> s.matches("^[0-9]+")).map(s -> Long.valueOf(s))
                .toArray(Long[]::new);
    }

    public static boolean isSameDay(LocalDateTime dateOne, LocalDateTime dateTwo) {
        if (dateOne == null || dateTwo == null)
            return dateOne == null && dateTwo == null;
        return dateOne.toLocalDate().equals(dateTwo.toLocalDate());
    }

    public static void setEntityBaseValue(EntityBaseClass entityBaseClass, Person loggedInUser) {
        if (entityBaseClass.getId() == null) {
            entityBaseClass.setAddedDate(HelperUtil.getLocalDateTimeOfUTC());
            entityBaseClass.setAddedPerson(loggedInUser);
            entityBaseClass.setDisabled(false);
            entityBaseClass.setUpdatedPerson(entityBaseClass.getAddedPerson());
            entityBaseClass.setUpdatedDate(entityBaseClass.getAddedDate());
        } else {
            entityBaseClass.setUpdatedPerson(loggedInUser);
            entityBaseClass.setUpdatedDate(HelperUtil.getLocalDateTimeOfUTC());
        }
    }
}
