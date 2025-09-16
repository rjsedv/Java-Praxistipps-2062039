package de.rjs;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;

import java.util.List;

public class Systemmonitor {
    public static void main(String[] args) throws InterruptedException {
        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();
        GlobalMemory memory = si.getHardware().getMemory();
        FileSystem fs = si.getOperatingSystem().getFileSystem();

        // Erste Tick-Messung holen
        long[] prevTicks = cpu.getSystemCpuLoadTicks();

        while (true) {
            Thread.sleep(2000); // Wartezeit, damit sich Ticks ändern

            // CPU-Auslastung zwischen den letzten Ticks und jetzt
            double cpuLoad = cpu.getSystemCpuLoadBetweenTicks(prevTicks) * 100;

            // Neue Ticks für den nächsten Durchlauf speichern
            prevTicks = cpu.getSystemCpuLoadTicks();

            // RAM
            long totalRam = memory.getTotal() / 1024 / 1024;
            long usedRam = (memory.getTotal() - memory.getAvailable()) / 1024 / 1024;

            // Festplatten
            List<OSFileStore> fsList = fs.getFileStores();

            System.out.println("===== System Monitor =====");
            System.out.printf("CPU Load: %.2f %%\n", cpuLoad);
            System.out.printf("RAM Used: %d MB / %d MB\n", usedRam, totalRam);

            System.out.println("Disks:");
            for (OSFileStore store : fsList) {
                long total = store.getTotalSpace() / 1024 / 1024;
                long used = (store.getTotalSpace() - store.getUsableSpace()) / 1024 / 1024;
                System.out.printf(" - %s: %d MB used / %d MB total\n", store.getName(), used, total);
            }

            System.out.println("==========================\n");
        }
    }
}
