package com.example.trabajo1modulo6.utils;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

@ProvidedTypeConverter
public class dateFunc{
    @TypeConverter
    public Date StringToLocalDate(String string) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return formatter.parse(string);// Or handle the exception as needed
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @TypeConverter
    public String LocalDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        return formatter.format(date);
    }
    public dateFunc(){

    }
}