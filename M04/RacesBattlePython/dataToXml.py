from mysql.connector import *
from xml.dom import minidom as xmldom
# Conectamos con la base de datos y sacamos los datos
database = connect(user="root", password="1234", host="127.0.0.1", database="RacesPAC")
cursorObject = database.cursor(buffered=True)

query = ("select p.player_name, b.* from BATTLE b join PLAYERS p on p.Player_id = b.Player_id order by Battle_Points desc;")
cursorObject.execute(query)
database.commit()
result_raw = cursorObject.fetchall()

# Creamos documento XML a partir de la informacion de la base de datos
doc = xmldom.Document()
root = doc.createElement("Battles")
doc.appendChild(root)
# Iteramos sobre el output de la base de datos
for i in result_raw:
    print(i)
for item in result_raw:
    item_element = doc.createElement("battle")
    item_element.setAttribute("battle_id", str(item[1]))
    root.appendChild(item_element)

    player_name = doc.createElement("player_name")
    player_name.appendChild(doc.createTextNode(str(item[0])))
    item_element.appendChild(player_name)

    player_id = doc.createElement("player_id")
    player_id.appendChild(doc.createTextNode(str(item[2])))
    item_element.appendChild(player_id)

    warrior_id = doc.createElement("warrior_id")
    warrior_id.appendChild(doc.createTextNode(str(item[3])))
    item_element.appendChild(warrior_id)

    warrior_weapon_id = doc.createElement("warrior_weapon_id")
    warrior_weapon_id.appendChild(doc.createTextNode(str(item[4])))
    item_element.appendChild(warrior_weapon_id)

    opponent_id = doc.createElement("opponent_id")
    opponent_id.appendChild(doc.createTextNode(str(item[5])))
    item_element.appendChild(opponent_id)

    opponent_weapon_id = doc.createElement("opponent_weapon_id")
    opponent_weapon_id.appendChild(doc.createTextNode(str(item[6])))
    item_element.appendChild(opponent_weapon_id)

    injuries_caused = doc.createElement("injuries_caused")
    injuries_caused.appendChild(doc.createTextNode(str(item[7])))
    item_element.appendChild(injuries_caused)

    injuries_suffered = doc.createElement("injuries_suffered")
    injuries_suffered.appendChild(doc.createTextNode(str(item[8])))
    item_element.appendChild(injuries_suffered)

    battle_points = doc.createElement("battle_points")
    battle_points.appendChild(doc.createTextNode(str(item[9])))
    item_element.appendChild(battle_points)

with open("xml/battle.xml", "w") as f:
    f.write(doc.toprettyxml())


