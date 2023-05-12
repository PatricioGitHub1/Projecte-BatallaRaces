from lxml import etree

# Funcions
# Read XML

def read_xml(path):
    file = open(path, 'r', encoding='utf-8')
    string = file.read()
    file.close()
    return bytes(bytearray(string, encoding='utf-8'))

# Write HTML file

def write_html(path, html):
    file = open(path, 'w', encoding='utf-8')
    file.write(html)
    file.close()

# transformation

def transform(xmlTree, type):
    # Crear l'arbre XSL per l'index de totes les noticies
    xslmicro = read_xml('xml/template.xsl')
    xslTreemicro = etree.XML(xslmicro)

    # Transformar l'arxiu de dades-microsiervos.rss segons l'arxiu template-microsiervos.xsl
    transform = etree.XSLT(xslTreemicro)
    htmlDom = transform(xmlTree, paramType="'" + type + "'")
    htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('utf-8')
    write_html("html/battle.html", htmlResult)


xml = read_xml('xml/battle.xml')
xmlTree = etree.XML(xml)

transform(xmlTree, "Game Ranking")
