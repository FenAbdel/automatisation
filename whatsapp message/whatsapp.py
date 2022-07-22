import time
import webbrowser as wb
import pyautogui 


#insert here the list of numbers and the name of your destination ,format :("name";"+ABCnumber")
numbers = {
    "name1":"+2126123456789",
}

for key, value in numbers.items():
    text = f"my message to {key}"
    wb.open(f"https://web.whatsapp.com/send?phone={value}&text={text}") #it opens whatsapp and go directely to the messenger with the number in values even if it doesn't exit
    time.sleep(15) #wait for whatsapp web to open 
    pyautogui.press("enter")
