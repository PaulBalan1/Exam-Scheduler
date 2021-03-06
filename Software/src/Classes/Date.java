package Classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class Date implements Serializable
{
  private int year, month, day;

  public Date(int day, int month, int year){
    setDay(day);
    setMonth(month);
    setYear(year);
  }

  public Date(int day, int month){
    setDay(day);
    setMonth(month);
    setYear(Calendar.getInstance().get(Calendar.YEAR)); //Sets to current year
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Date date = (Date) o;
    return year == date.year && month == date.month && day == date.day;
  }

  @Override public int hashCode()
  {
    return Objects.hash(year, month, day);
  }

  @Override public String toString()
  {
    String s="";
    if(day<10) s="0";
    return s+day+"/"+month+"/"+year;
  }
}
