#https://stackoverflow.com/questions/75379700/want-to-create-random-cards-using-faker
class BaseContacs:
    def __init__(self, name, surname, phone, email):
        self.name = name
        self.surname = surname
        self.phone = phone
        self.email = email
        

        #Variables
        self._label_lenght = len(name) + len(surname) +1
    

    def contact(self, ):
        print(f" Wybieram numer", self.phone, "i dzwonię do", self.name, self.surname)


    def __str__(self):
        return f'{self.name} {self.surname} {self.phone} {self.email}'
     
    @property
    def label_lenght(self):
        return self._label_lenght
    

class BuisnessContact(BaseContacs):
    def __init__(self, position, company, company_phone, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.position = position
        self.company = company
        self.company_phone = company_phone

    def buisnesscontact(self,):
        print(f" Wybieram numer firmowy", self.company_phone, "i dzwonię do", self.name, self.surname, self.position, "w", self.company, "company")


kontakt1 = BaseContacs(name="Adam", 
                       surname="Nowak", 
                       phone=777666777, 
                       email="adam.nowak@op.pl")

kontakt2 = BuisnessContact(name="Stefan", 
                           surname="Jajko",
                           phone=777667777, 
                           email="stefan.jajko@op.pl",
                           company_phone=727666777, 
                           position="manager", 
                           company="diablo")

print(kontakt1)
print(kontakt2)