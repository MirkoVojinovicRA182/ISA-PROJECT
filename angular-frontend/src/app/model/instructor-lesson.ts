
export class InstructorLesson{
    id: number = 0;
    name: string = "";
    address: string = "";
    promotionalDescription: string = "";
    instructorBiography: string = "";
    maxCountOfParticipants: string = "";
    rulesOfConduct: string = "";
    defaultEquipment: string = "";
    pricelist: string = "";
    termsOfUse: string = "";


    constructor(lesson: InstructorLesson){
        this.id = lesson.id;
        this.name = lesson.name;
        this.address = lesson.address;
        this.promotionalDescription = lesson.promotionalDescription;
        this.instructorBiography = lesson.instructorBiography;
        this.maxCountOfParticipants = lesson.maxCountOfParticipants;
        this.rulesOfConduct = lesson.rulesOfConduct;
        this.defaultEquipment = lesson.defaultEquipment;
        this.pricelist = lesson.pricelist;
        this.termsOfUse = lesson.termsOfUse;
    }
}