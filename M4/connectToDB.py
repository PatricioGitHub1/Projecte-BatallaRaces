from mysql.connector import *
from xml.dom import minidom as xmldom
# Conectamos con la base de datos y sacamos los datos
database = connect(user="root", password="1234", host="127.0.0.1", database="RacesPAC")
cursorObject = database.cursor(buffered=True)

query = ("select * from BATTLE order by Battle_Points desc;")
cursorObject.execute(query)
database.commit()
result_raw = cursorObject.fetchall()

# Creamos documento XML a partir de la informacion de la base de datos
doc = xmldom.Document()
root = doc.createElement("Battles")
doc.appendChild(root)
# Iteramos sobre el output de la base de datos
for item in result_raw:
    item_element = doc.createElement("battle")
    item_element.setAttribute("battle_id", str(item[0]))
    root.appendChild(item_element)

    player_id = doc.createElement("player_id")
    player_id.appendChild(doc.createTextNode(str(item[1])))
    item_element.appendChild(player_id)

    warrior_id = doc.createElement("email")
    warrior_id.appendChild(doc.createTextNode(str(item[2])))
    item_element.appendChild(warrior_id)

with open("battle.xml", "w") as f:
    f.write(doc.toprettyxml())


