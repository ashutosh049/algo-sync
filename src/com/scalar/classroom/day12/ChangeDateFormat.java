package com.scalar.classroom.day12;

public class ChangeDateFormat {

  public static void main(String[] args) {

    String d1 = "2nd Feb 2013";
    System.out.println(d1 + ": " + solve(d1));

    d1 = "1st Mar 1984 ";
    System.out.println(d1 + ": " + solve(d1));

    d1 = "25th Apr 2217";
    System.out.println(d1 + ": " + solve(d1));
  }

  public static String solve(String dateStr) {
    StringBuilder dateBuilder = new StringBuilder();

    String[] dateArr = dateStr.trim().toUpperCase().split(" ");
    final String dateSeperator = "-";
    String day = dateArr[0];
    String mon = dateArr[1];
    String year = dateArr[2];

    dateBuilder.append(year);
    dateBuilder.append(dateSeperator);

    int month = Month.valueOf(mon).ordinal() + 1;

    dateBuilder.append(getZeroBasedNumbers(month));
    dateBuilder.append(dateSeperator);

    int date = Integer.valueOf(day.substring(0, day.length()-2));

    dateBuilder.append(getZeroBasedNumbers(date));

    return dateBuilder.toString();

  }

  private static String getZeroBasedNumbers(int num) {
    if (String.valueOf(num).length() == 1) {
      return "0" + String.valueOf(num);
    } else {
      return String.valueOf(num);
    }
  }

  private enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
  }
}
