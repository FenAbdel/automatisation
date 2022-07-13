import time
import webbrowser as wb
import pyperclip
import pyautogui 


#insert here the list of numbers and the name of your destination ,format :("name";"+ABCnumber")
data = {
    "name1":"+2126123456789",
}

for key, value in data.items():
    wb.open(f"https://web.whatsapp.com/send?phone={value}") #if open whatsapp and go directely to the essenger with the number in values even if it doesn't exit
    text = f"my message to {key}" #type your message here ,{key} is in cast you want to write a message with names 
    time.sleep(20) #wait for whatsapp web to open 
    pyperclip.copy(text)  
    pyautogui.hotkey("ctrl", "v") 
    pyautogui.press("enter")