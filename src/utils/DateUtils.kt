package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Utility object for handling date operations
 */
object DateUtils {

    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    /**
     * Parses a date string in dd/MM/yyyy format
     * @param dateString The date string to parse
     * @return LocalDate object or null if parsing fails
     */
    fun parseDate(dateString: String): LocalDate? {
        return try {
            if (dateString.isBlank()) return null
            LocalDate.parse(dateString, formatter)
        } catch (e: DateTimeParseException) {
            null
        }
    }

    /**
     * Formats a LocalDate to dd/MM/yyyy string
     * @param date The LocalDate to format
     * @return Formatted date string
     */
    fun formatDate(date: LocalDate): String {
        return date.format(formatter)
    }

    /**
     * Checks if a date string is in valid format
     * @param dateString The date string to validate
     * @return true if valid, false otherwise
     */
    fun isValidDateFormat(dateString: String): Boolean {
        return parseDate(dateString) != null
    }

    /**
     * Gets the current date
     * @return Current LocalDate
     */
    fun getCurrentDate(): LocalDate {
        return LocalDate.now()
    }

    /**
     * Checks if a date is in the past
     * @param date The date to check
     * @return true if date is before today
     */
    fun isPastDate(date: LocalDate): Boolean {
        return date.isBefore(getCurrentDate())
    }

    /**
     * Checks if a date is today
     * @param date The date to check
     * @return true if date is today
     */
    fun isToday(date: LocalDate): Boolean {
        return date.isEqual(getCurrentDate())
    }

    /**
     * Checks if a date is in the future
     * @param date The date to check
     * @return true if date is after today
     */
    fun isFutureDate(date: LocalDate): Boolean {
        return date.isAfter(getCurrentDate())
    }
}