package utils

fun Int?.isNullOrNegative(): Boolean = this == null || this < 0

fun String?.isNullOrEmpty(): Boolean = this == null || this.isEmpty()