package com.lapsa.insurance.domain;

import java.util.List;

public interface ScanCopiedDocument {
    List<UploadedImage> getScanFiles();

    void setScanFiles(List<UploadedImage> scanFiles);

    void addScanFile(UploadedImage im);

    void removeScanFile(UploadedImage im);
}
