function choice(pic_location, other_conditions ){
    if(pic_location < 9) { 
        if( other_conditions == 1 ){
                console.log("First condition true");
            } else {
                console.log("First Condition False");
            }
    } else {
        if(pic_location == 10){
            console.log("Second Condition True");
        } else {
            console.log("Second Condition False");
        }
    }
}

choice(8,1) // First condition true
choice(8,2) //First Condition False
choice(10,1) //Second Condition True
choice(11,2) //Second Condition False