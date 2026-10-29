
#!/bin/bash

LOG_FILE="logs/Arysbay_Miras_system_report.log"

{
    echo "======================================"
    echo "     DEVOPS SYSTEM MONITORING REPORT"
    echo "======================================"

    echo "Student: Miras Arysbay"
    echo "Date and Time: $(date)"
    echo "Current User: $(whoami)"

    echo "--------------------------------------"
    echo "OPERATING SYSTEM"
    echo "--------------------------------------"
    cat /etc/os-release | grep PRETTY_NAME
    echo "Kernel Version: $(uname -r)"

    echo "--------------------------------------"
    echo "CPU INFORMATION"
    echo "--------------------------------------"
    lscpu | grep -m 1 "Model name"

    echo "--------------------------------------"
    echo "MEMORY INFORMATION"
    echo "--------------------------------------"
    free -h

    echo "--------------------------------------"
    echo "DISK USAGE AND AVAILABLE SPACE"
    echo "--------------------------------------"
    df -h .

    echo "======================================"
    echo "Report completed successfully!"
    echo "======================================"
} | tee -a "$LOG_FILE"


