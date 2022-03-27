from bs4 import BeautifulSoup
import pprint
import json


class EmployeeInfo:
    def __init__(self, name, position, office_location, age, start_date, salary):
        self.name = name
        self.position = position
        self.office_location = office_location
        self.age = age
        self.start_date = start_date
        self.salary = salary



soup = BeautifulSoup(open("index.txt"), 'html.parser')

employeeList = []

for employee in soup.find_all('tr'):
    employeeElement = [column.get_text() for column in employee.find_all_next('td')]
    employeeList.append(employeeElement)


jsonList = []
count = 3
for employee in employeeList:
    localDict = {"pk": count,
                 "_name": employee[0],
                 "position": employee[1],
                 "officeLocation": employee[2],
                 "age": employee[3],
                 "salary": employee[5][1:].replace(",", ""),
                 "startDate": employee[4].replace("/", "-", 2)
                 }
    jsonList.append(localDict)
    count += 1

printedFormat = json.dumps(jsonList)

print(printedFormat)
