package com.example.starwarapi_retrofit_rxjava.common


fun Conversion(centi: Int): String {
    val inch = 0.3937 * centi
    val feet = 0.0328 * centi
    System.out.printf("Inches is: %.2f \n", inch)
    System.out.printf("Feet is: %.2f", feet)
    val a = String.format("%.0f", inch).toInt()
    val b = String.format("%.1f", feet).toFloat()
    return b.toString()

}