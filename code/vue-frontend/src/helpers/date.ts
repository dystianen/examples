import { format, differenceInDays, addDays, subDays } from 'date-fns'

/**
 * Format a date to a specific format
 * @param {Date | string | number} date - The date to format
 * @param {string} formatStr - The format string (default: 'yyyy-MM-dd HH:mm:ss')
 * @returns {string} Formatted date string
 */
export const formatDate = (date, formatStr = 'yyyy-MM-dd HH:mm:ss') => {
  return format(new Date(date), formatStr)
}

/**
 * Get the current timestamp
 * @returns {string} Current timestamp
 */
export const getCurrentTimestamp = () => {
  return format(new Date(), 'yyyy-MM-dd HH:mm:ss')
}

/**
 * Calculate the difference between two dates in days
 * @param {Date | string | number} date1 - The first date
 * @param {Date | string | number} date2 - The second date
 * @returns {number} Difference in days
 */
export const getDateDifference = (date1, date2) => {
  return differenceInDays(new Date(date1), new Date(date2))
}

/**
 * Add days to a date
 * @param {Date | string | number} date - The base date
 * @param {number} days - Number of days to add
 * @returns {string} New date after addition
 */
export const addDaysToDate = (date, days) => {
  return format(addDays(new Date(date), days), 'yyyy-MM-dd HH:mm:ss')
}

/**
 * Subtract days from a date
 * @param {Date | string | number} date - The base date
 * @param {number} days - Number of days to subtract
 * @returns {string} New date after subtraction
 */
export const subtractDaysFromDate = (date, days) => {
  return format(subDays(new Date(date), days), 'yyyy-MM-dd HH:mm:ss')
}
