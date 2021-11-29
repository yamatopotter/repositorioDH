let fizzBuzz = (a,b) => {
    for(let i=1; i<=100; i++){
        if((i%a==0) && (i%b==0)){
            console.log('FizzBuzz');
        }
        else if(i%a==0){
            console.log('Fizz');
        }
        else if(i%b==0){
            console.log('Buzz');
        }
        else{
            console.log(i);
        }
    }
}

fizzBuzz(2,6);