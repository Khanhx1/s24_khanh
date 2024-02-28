let student = {
    firstName: 'John',
    gender: 'male',
    degree: 'Bachelor',
    english: 'English'

}
function displayInfo({ firstName = "Quân", degree = "N/A" }) {
    console.log(`firstName: ${firstName}, degree: ${degree}`);
}

console.log(displayInfo(student));