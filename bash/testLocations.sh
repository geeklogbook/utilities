#ping -c2 www.google.com >> correct.txt 2>> error.txt

ipReport() {
    while IFS= read -r ip; 
    do
        ping -c4 $ip >> correct.txt 2>> error.txt
    done < $1
}

ipReport ip_list.txt

