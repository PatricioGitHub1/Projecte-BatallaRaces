<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="paramId"/>
    <xsl:template match="/Battles">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <link rel="stylesheet" href="battle.css"></link>
                <title><xsl:value-of select="$paramType"/></title>
            </head>
            <body>
                <div class="autocenter">
                    <div class="battles_header">
                        <p>Player ID</p>
                        <p>Username</p>
                        <p>Battle ID</p>
                        <p>Warrior ID</p>
                        <p>Weapon ID</p>
                        <p>Opponent's Warrior</p>
                        <p>Opponent's Weapon</p>
                        <p>Total Damage Given</p>
                        <p>Total Damage Taken</p>
                        <p>Total Battle Points</p>

                    </div>
                    <div class ="all_battles">
                        <xsl:for-each select="battle">
                            <div class="single_battle">
                                <p><xsl:value-of select="player_id"/></p>   
                                <p><xsl:value-of select="player_name"/></p>
                                <p><xsl:value-of select="@battle_id"/></p>
                                <p><xsl:value-of select="warrior_id"/></p>
                                <p><xsl:value-of select="warrior_weapon_id"/></p>
                                <p><xsl:value-of select="opponent_id"/></p>
                                <p><xsl:value-of select="opponent_weapon_id"/></p>
                                <p><xsl:value-of select="injuries_caused"/></p>
                                <p><xsl:value-of select="injuries_suffered"/></p>
                                <p><xsl:value-of select="battle_points"/></p>
                            </div>  
                        </xsl:for-each>
                    </div>
                </div>
            </body>
        </html> 
    </xsl:template>
</xsl:stylesheet>
