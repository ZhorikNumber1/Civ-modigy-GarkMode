package com.example.api.Service;

import com.example.api.Model.Mods_units;
import com.example.api.Model.Units_civilian;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;
@Service
public interface mod_textService {


    static @NotNull String getId() {

        StringBuilder stringid = new StringBuilder();
        String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(hexDigits.length);
            stringid.append(hexDigits[randomIndex]);
        }
        stringid.append("-");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                int randomIndex = random.nextInt(hexDigits.length);
                stringid.append(hexDigits[randomIndex]);
            }
            stringid.append("-");
        }
        for (int i = 0; i < 12; i++) {
            int randomIndex = random.nextInt(hexDigits.length);
            stringid.append(hexDigits[randomIndex]);
        }
        return stringid.toString();
    }

    static String modInfoFile_text(Mods_units unitsCvilianDto) {
        Date datamod_let = new Date();
        long datamod = datamod_let.getTime() / 1000;
        String idXML = mod_textService.getId();
        String captionXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Mod id=\"" + idXML + "\" version=\"1\">";
        String nameXML = "\n\t<Properties>" +
                "\n\t\t<Name>[COLOR_Red]CivModify:[ENDCOLOR]" +  unitsCvilianDto.getNameMod() + "</Name>";
        String descriptionXML = "\n\t\t<Description>" + unitsCvilianDto.getDescription() + "</Description>";
        String dataXML = "\n\t\t<Created>" + datamod + "</Created>";
        String teaserXML = "\n\t\t<Teaser>" + unitsCvilianDto.getNameMod() + "</Teaser>";
        String authorXML = "\n\t\t<Authors>CivModify, " + unitsCvilianDto.getAuthor() + "</Authors>";
        String CompatibleVersionsXML = "\n\t\t<CompatibleVersions>1.2,2.0</CompatibleVersions>";
        String PropertiesXML = "\n\t</Properties>";
        String Title = captionXML + nameXML + descriptionXML + dataXML + teaserXML + authorXML + CompatibleVersionsXML + PropertiesXML;
        return Title + mod_textService.inGameActions(idXML, unitsCvilianDto);
    }
    static String xmlDBFile_inGameActions(Mods_units modsUnits, Optional<Units_civilian> exsting_Unit){
        String title = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
        String finalXmltext = "<GameData>\n" +
                "\t<Units>\n" +
                "\t\t<Update>\n" +
                "\t\t\t<Where UnitType=\""+modsUnits.getUnitType()+"\" />\n" +
                "\t\t\t<Set ";
        String endTextXml = "\t\t</Update>\n" +
                "\t</Units>\n" +
                "</GameData>";
        if(exsting_Unit.get().getCombat() != modsUnits.getCombat()){
            finalXmltext+="Combat =\""+modsUnits.getCombat()+"\" ";
        }
        if(exsting_Unit.get().getCost() != modsUnits.getCost()){
             finalXmltext+="Cost =\""+modsUnits.getCost()+"\" ";
        }
        if(exsting_Unit.get().getBaseMoves() != modsUnits.getBaseMoves()){
            finalXmltext+="BaseMoves =\""+modsUnits.getBaseMoves()+"\" ";
        }
        return title+finalXmltext+"/>\n"+endTextXml;
    }

    static String inGameActions(String id, Mods_units unitsCvilianDto) {
        String openTegXML = "\n\t<InGameActions>";
        String closeTegXML = "\n\t</InGameActions>";
        String updateDatabaseXML = "\n\t\t<UpdateDatabase id=\"" + id + "\">";
        String fileXML = "\n\t\t\t<File>" + unitsCvilianDto.getName() + unitsCvilianDto.getNameMod() + ".xml</File>";
        String updateDatabaseCloseXML = "\n\t\t</UpdateDatabase>";
        String openfilestagXML = "\n\t<Files>";
        String closefilestagXML = "\n\t</Files>";

        return openTegXML + updateDatabaseXML + fileXML + updateDatabaseCloseXML + closeTegXML + openfilestagXML + fileXML + closefilestagXML+"\n</Mod>";
    }

}
