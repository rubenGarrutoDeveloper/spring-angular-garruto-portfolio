package com.garruto.portfolio_backend.controller.mvc;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/projects")
public class ProjectsController {

    @GetMapping
    public String projects() {
        log.info("Rendering projects page");
        return "projects/projects-home";
    }

    @GetMapping("/project-server-health")
    public String project1(Model model) throws InterruptedException {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        GlobalMemory ram = hal.getMemory();

        // 1. Calcolo Carico CPU (richiede un piccolo delay per il campionamento)
        long[] prevTicks = cpu.getSystemCpuLoadTicks();
        Thread.sleep(200); // Piccolo campionamento di 200ms
        double cpuLoad = cpu.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        model.addAttribute("cpuUsage", String.format("%.1f%%", cpuLoad));

        // 2. Uptime del Sistema (da quanto tempo è acceso il PC/Server)
        long uptimeSeconds = si.getOperatingSystem().getSystemUptime();
        long days = uptimeSeconds / 86400;
        long hours = (uptimeSeconds % 86400) / 3600;
        long minutes = (uptimeSeconds % 3600) / 60;
        model.addAttribute("uptime", String.format("%d giorni, %d ore, %d minuti", days, hours, minutes));

        // --- Dati già presenti ---
        model.addAttribute("cpuModel", cpu.getProcessorIdentifier().getName());

        double totalRam = ram.getTotal() / (1024.0 * 1024 * 1024);
        double availableRam = ram.getAvailable() / (1024.0 * 1024 * 1024);
        model.addAttribute("ramTotal", String.format("%.2f GB", totalRam));
        model.addAttribute("ramUsed", String.format("%.2f GB", totalRam - availableRam));

        List<HWDiskStore> disks = hal.getDiskStores();
        if (!disks.isEmpty()) {
            double diskSize = disks.get(0).getSize() / (1024.0 * 1024 * 1024);
            model.addAttribute("diskSize", String.format("%.2f GB", diskSize));
        }

        double cpuTemp = hal.getSensors().getCpuTemperature();
        model.addAttribute("temp", cpuTemp);

        return "projects/project-server-health/project-server-health";
    }
    @GetMapping("/project2")
    public String project2() {
        return "projects/project2/project2";
    }

    @GetMapping("/project3")
    public String project3() {
        return "projects/project3/project3";
    }
}
