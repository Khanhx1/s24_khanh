let isPrime = (number) => {
    if (number <= 1){
        return false;
    }
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0){
            return false;
        }

    }
    return true;
}
console.log(isPrime(9));

//Yêu cầu 2

let integerNumber = [1,2,3,6,9,11,12,22,23,77];

let primeArray = integerNumber.filter(number => isPrime(number));

console.log(primeArray);
