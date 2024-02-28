let student = {
    firstName: 'John',
    gender: 'male',
    degree: 'Bachelor',
    english: 'English'

}
let getInfo = (person) => {
    person.firstName === undefined ? console.log("firstName: Quân") : console.log(`firstName: ${person.firstName}`);
    person.degree === undefined ? console.log("Degree: Na") : console.log(`Degree: ${person.degree}`);
    return ""
}

console.log(getInfo(student));