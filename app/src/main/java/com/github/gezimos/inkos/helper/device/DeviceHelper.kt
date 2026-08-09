package com.github.gezimos.inkos.helper.device

import android.os.Build

object DeviceHelper {

    fun isMuditaKompakt(): Boolean {
        return Build.BRAND.equals("Mudita", ignoreCase = true) ||
               Build.MODEL.equals("Kompakt", ignoreCase = true) ||
               Build.DEVICE.equals("Kompakt", ignoreCase = true) ||
               Build.PRODUCT.equals("Kompakt", ignoreCase = true)
    }

    fun isEinkDevice(): Boolean {
        if (isMuditaKompakt()) return true

        val brand = Build.BRAND.lowercase()
        val manufacturer = Build.MANUFACTURER.lowercase()
        val model = Build.MODEL.lowercase()

        return when {
            // Onyx Boox
            manufacturer == "onyx" || brand == "boox" -> true
            // Hisense A-series e-ink phones
            manufacturer == "hisense" && model.startsWith("a") -> true
            // Bigme
            manufacturer == "bigme" || brand == "bigme" -> true
            // Dasung
            manufacturer == "dasung" || brand == "dasung" -> true
            // HiBreak
            manufacturer == "hibreak" || brand == "hibreak" -> true
            // Vivwoods
            manufacturer == "vivwoods" || brand == "vivwoods" -> true
            // Minimal Phone
            brand == "minimal" || model.contains("minimal phone") -> true
            // TCL NXTPAPER (e-ink-like)
            manufacturer == "tcl" && model.contains("nxtpaper") -> true
            // Xiaomi InkPalm
            manufacturer == "xiaomi" && model.contains("inkpalm") -> true
            else -> false
        }
    }

    fun isQwertyDevice(): Boolean {
        val brand = Build.BRAND.lowercase()
        val manufacturer = Build.MANUFACTURER.lowercase()
        val model = Build.MODEL.lowercase()

        return when {
            // Unihertz Titan / Titan Pocket / Titan Slim / Titan 2
            (manufacturer == "unihertz" || brand == "unihertz") && model.contains("titan") -> true
            // Clicks Communicator
            manufacturer == "clicks" || brand == "clicks" || model.contains("clicks communicator") -> true
            // Minimal PH-1
            (brand == "minimal" || manufacturer == "minimal") && model.contains("ph-1") -> true
            model.contains("ph-1") && (brand.contains("minimal") || manufacturer.contains("minimal")) -> true
            // Zinwa Q25 / Q26 / Q27
            manufacturer == "zinwa" || brand == "zinwa" -> true
            model.startsWith("q25") || model.startsWith("q26") || model.startsWith("q27") -> true
            // BlackBerry Passport / Key series (Key2, KeyOne, Key2 LE)
            manufacturer == "blackberry" || brand == "blackberry" -> true
            model.contains("passport") -> true
            model.startsWith("key") && (brand.contains("bb") || manufacturer.contains("tcl") || manufacturer.contains("blackberry")) -> true
            else -> false
        }
    }
}
