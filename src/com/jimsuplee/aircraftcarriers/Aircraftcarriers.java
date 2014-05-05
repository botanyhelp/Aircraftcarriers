/**Copyright (C) 2013 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.aircraftcarriers;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import java.util.HashMap;
//import java.util.Map;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
//import android.util.Log;
import android.widget.Button;
//import android.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.database.Cursor;
import android.widget.EditText;
import java.util.List;
import java.util.ArrayList;

public class Aircraftcarriers extends Activity {
	static final String TAG = "CARRIERS";
	static String navy = "";
	static List<String> carrierSearchList = new ArrayList<String>();
	HashMap<String,Integer> carrierMap = new HashMap<String,Integer>();
	HashMap<String,Integer> photoMap = new HashMap<String,Integer>();
	DBAdapter db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			String destPath = "/data/data/" + getPackageName() + "/databases";
			File f = new File(destPath);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();
				Toast.makeText(this, "Please Wait...Database Being Created",
						Toast.LENGTH_LONG).show();
				CopyDB(getBaseContext().getAssets().open("carrier"),
						new FileOutputStream(destPath + "/carrier"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Now that we (hopefully) have an SQLiteDatabase available, lets make
		// an adapter and put it
		// into our global variable.
		db = new DBAdapter(this);
	    photoMap.put("USS_Abraham_Lincoln", R.drawable.uss_abraham_lincoln_cvn_72);
	    photoMap.put("ARA_Independencia_1958", R.drawable.uss_abraham_lincoln_cvn_72);
	    photoMap.put("Japanese_battlecruiser_Amagi", R.drawable.japanese_battlecruiser_amagi);
	    photoMap.put("USS_Wake_Island_CVE65", R.drawable.uss_wake_island_cve65);
        photoMap.put("ARA_Independencia_1958", R.drawable.ara_independencia_1958);
        photoMap.put("ARA_Veinticinco_de_Mayo_V2", R.drawable.ara_veinticinco_de_mayo_v2);
        photoMap.put("Brazilian_aircraft_carrier_Minas_Gerais", R.drawable.brazilian_aircraft_carrier_minas_gerais);
        photoMap.put("Brazilian_aircraft_carrier_Sao_Paulo_A12", R.drawable.brazilian_aircraft_carrier_sao_paulo_a12);
        photoMap.put("Chinese_aircraft_carrier_Liaoning", R.drawable.chinese_aircraft_carrier_liaoning);
        photoMap.put("Flugzeugtrager_B", R.drawable.flugzeugtrager_b);
        photoMap.put("French_aircraft_carrier_Arromanches_R95", R.drawable.french_aircraft_carrier_arromanches_r95);
        photoMap.put("French_aircraft_carrier_Bearn", R.drawable.french_aircraft_carrier_bearn);
        photoMap.put("French_aircraft_carrier_Bois_Belleau", R.drawable.french_aircraft_carrier_bois_belleau);
        photoMap.put("French_aircraft_carrier_Charles_de_Gaulle_R91", R.drawable.french_aircraft_carrier_charles_de_gaulle_r91);
        photoMap.put("French_aircraft_carrier_Charles_de_Gaulle_R91", R.drawable.french_aircraft_carrier_charles_de_gaulle_r91);
        photoMap.put("French_aircraft_carrier_Clemenceau_R98", R.drawable.french_aircraft_carrier_clemenceau_r98);
        photoMap.put("French_aircraft_carrier_Dixmude", R.drawable.french_aircraft_carrier_dixmude);
        photoMap.put("French_aircraft_carrier_Foch_R99", R.drawable.french_aircraft_carrier_foch_r99);
        photoMap.put("French_aircraft_carrier_Joffre", R.drawable.french_aircraft_carrier_joffre);
        photoMap.put("French_aircraft_carrier_La_Fayette_R96", R.drawable.french_aircraft_carrier_la_fayette_r96);
        photoMap.put("French_aircraft_carrier_Painleve", R.drawable.french_aircraft_carrier_painleve);
        photoMap.put("French_aircraft_carrier_Verdun", R.drawable.french_aircraft_carrier_verdun);
        photoMap.put("French_seaplane_carrier_Commandant_Teste", R.drawable.french_seaplane_carrier_commandant_teste);
        photoMap.put("French_seaplane_carrier_Foudre", R.drawable.french_seaplane_carrier_foudre);
        photoMap.put("French_submarine_Surcouf", R.drawable.french_submarine_surcouf);
        photoMap.put("German_aircraft_carrier_Graf_Zeppelin", R.drawable.german_aircraft_carrier_graf_zeppelin);
        photoMap.put("German_cruiser_Seydlitz", R.drawable.german_cruiser_seydlitz);
        photoMap.put("HMAS_Albatross_1928", R.drawable.hmas_albatross_1928);
        photoMap.put("HMAS_Melbourne_R21", R.drawable.hmas_melbourne_r21);
        photoMap.put("HMAS_Sydney_R17", R.drawable.hmas_sydney_r17);
        photoMap.put("HMAS_Vengeance_R71", R.drawable.hmas_vengeance_r71);
        photoMap.put("HMCS_Bonaventure_CVL_22", R.drawable.hmcs_bonaventure_cvl_22);
        photoMap.put("HMCS_Magnificent_CVL21", R.drawable.hmcs_magnificent_cvl21);
        photoMap.put("HMCS_Warrior_R31", R.drawable.hmcs_warrior_r31);
        photoMap.put("HMS_Activity_D94", R.drawable.hms_activity_d94);
        photoMap.put("HMS_Albion_R07", R.drawable.hms_albion_r07);
        photoMap.put("HMS_Ameer_D01", R.drawable.hms_ameer_d01);
        photoMap.put("HMS_Arbiter_D31", R.drawable.hms_arbiter_d31);
        photoMap.put("HMS_Archer_D78", R.drawable.hms_archer_d78);
        photoMap.put("HMS_Argus_I49", R.drawable.hms_argus_i49);
        photoMap.put("HMS_Ark_Royal_1914", R.drawable.hms_ark_royal_1914);
        photoMap.put("HMS_Ark_Royal_91", R.drawable.hms_ark_royal_91);
        photoMap.put("HMS_Ark_Royal_R07", R.drawable.hms_ark_royal_r07);
        photoMap.put("HMS_Ark_Royal_R09", R.drawable.hms_ark_royal_r09);
        photoMap.put("HMS_Atheling_D51", R.drawable.hms_atheling_d51);
        photoMap.put("HMS_Attacker_D02", R.drawable.hms_attacker_d02);
        photoMap.put("HMS_Audacity_D10", R.drawable.hms_audacity_d10);
        photoMap.put("HMS_Avenger_D14", R.drawable.hms_avenger_d14);
        photoMap.put("HMS_Battler_D18", R.drawable.hms_battler_d18);
        photoMap.put("HMS_Begum_D38", R.drawable.hms_begum_d38);
        photoMap.put("HMS_BenmyChree", R.drawable.hms_benmychree);
        photoMap.put("HMS_Biter_D97", R.drawable.hms_biter_d97);
        photoMap.put("HMS_Bulwark_R08", R.drawable.hms_bulwark_r08);
        photoMap.put("HMS_Campania_1914", R.drawable.hms_campania_1914);
        photoMap.put("HMS_Campania_D48", R.drawable.hms_campania_d48);
        photoMap.put("HMS_Chaser_D32", R.drawable.hms_chaser_d32);
        photoMap.put("HMS_Colossus_R15", R.drawable.hms_colossus_r15);
        photoMap.put("HMS_Courageous_50", R.drawable.hms_courageous_50);
        photoMap.put("HMS_Dasher_D37", R.drawable.hms_dasher_d37);
        photoMap.put("HMS_Eagle_1918", R.drawable.hms_eagle_1918);
        photoMap.put("HMS_Eagle_R05", R.drawable.hms_eagle_r05);
        photoMap.put("HMS_Emperor_D98", R.drawable.hms_emperor_d98);
        photoMap.put("HMS_Empress_D42", R.drawable.hms_empress_d42);
        photoMap.put("HMS_Fencer_D64", R.drawable.hms_fencer_d64);
        photoMap.put("HMS_Formidable_67", R.drawable.hms_formidable_67);
        photoMap.put("HMS_Furious_47", R.drawable.hms_furious_47);
        photoMap.put("HMS_Glory_R62", R.drawable.hms_glory_r62);
        photoMap.put("HMS_Hermes_95", R.drawable.hms_hermes_95);
        photoMap.put("HMS_Hermes_R12", R.drawable.hms_hermes_r12);
        photoMap.put("HMS_Illustrious_87", R.drawable.hms_illustrious_87);
        photoMap.put("HMS_Illustrious_R06", R.drawable.hms_illustrious_r06);
        photoMap.put("HMS_Implacable_R86", R.drawable.hms_implacable_r86);
        photoMap.put("HMS_Indefatigable_R10", R.drawable.hms_indefatigable_r10);
        photoMap.put("HMS_Indomitable_92", R.drawable.hms_indomitable_92);
        photoMap.put("HMS_Invincible_R05", R.drawable.hms_invincible_r05);
        photoMap.put("HMS_Khedive_D62", R.drawable.hms_khedive_d62);
        photoMap.put("HMS_M2", R.drawable.hms_m2);
        photoMap.put("HMS_Manxman_1916", R.drawable.hms_manxman_1916);
        photoMap.put("HMS_Nabob_D77", R.drawable.hms_nabob_d77);
        photoMap.put("HMS_Nairana_1917", R.drawable.hms_nairana_1917);
        photoMap.put("HMS_Nairana_D05", R.drawable.hms_nairana_d05);
        photoMap.put("HMS_Ocean_L12", R.drawable.hms_ocean_l12);
        photoMap.put("HMS_Ocean_R68", R.drawable.hms_ocean_r68);
        photoMap.put("HMS_Patroller_D07", R.drawable.hms_patroller_d07);
        photoMap.put("HMS_Pegasus_1917", R.drawable.hms_pegasus_1917);
        photoMap.put("HMS_Powerful_R95", R.drawable.hms_powerful_r95);
        photoMap.put("HMS_Premier_D23", R.drawable.hms_premier_d23);
        photoMap.put("HMS_Prince_of_Wales_R09", R.drawable.hms_prince_of_wales_r09);
        photoMap.put("HMS_Puncher_D79", R.drawable.hms_puncher_d79);
        photoMap.put("HMS_Pursuer_D73", R.drawable.hms_pursuer_d73);
        photoMap.put("HMS_Queen_D19", R.drawable.hms_queen_d19);
        photoMap.put("HMS_Queen_Elizabeth_R08", R.drawable.hms_queen_elizabeth_r08);
        photoMap.put("HMS_Rajah_D10", R.drawable.hms_rajah_d10);
        photoMap.put("HMS_Ranee_D03", R.drawable.hms_ranee_d03);
        photoMap.put("HMS_Ravager_D70", R.drawable.hms_ravager_d70);
        photoMap.put("HMS_Ruler_D72", R.drawable.hms_ruler_d72);
        photoMap.put("HMS_Searcher_D40", R.drawable.hms_searcher_d40);
        photoMap.put("HMS_Shah_D21", R.drawable.hms_shah_d21);
        photoMap.put("HMS_Slinger_D26", R.drawable.hms_slinger_d26);
        photoMap.put("HMS_Smiter_D55", R.drawable.hms_smiter_d55);
        photoMap.put("HMS_Speaker_D90", R.drawable.hms_speaker_d90);
        photoMap.put("HMS_Stalker_D91", R.drawable.hms_stalker_d91);
        photoMap.put("HMS_Striker_D12", R.drawable.hms_striker_d12);
        photoMap.put("HMS_Terrible_R93", R.drawable.hms_terrible_r93);
        photoMap.put("HMS_Tracker_D24", R.drawable.hms_tracker_d24);
        photoMap.put("HMS_Trouncer_D85", R.drawable.hms_trouncer_d85);
        photoMap.put("HMS_Trumpeter_D09", R.drawable.hms_trumpeter_d09);
        photoMap.put("HMS_Unicorn_I72", R.drawable.hms_unicorn_i72);
        photoMap.put("HMS_Venerable_R63", R.drawable.hms_venerable_r63);
        photoMap.put("HMS_Vengeance_R71", R.drawable.hms_vengeance_r71);
        photoMap.put("HMS_Victorious_R38", R.drawable.hms_victorious_r38);
        photoMap.put("HMS_Vindex_1915", R.drawable.hms_vindex_1915);
        photoMap.put("HMS_Vindex_D15", R.drawable.hms_vindex_d15);
        photoMap.put("HMS_Warrior_R31", R.drawable.hms_warrior_r31);
        photoMap.put("HNLMS_Karel_Doorman_QH1", R.drawable.hnlms_karel_doorman_qh1);
        photoMap.put("HNLMS_Karel_Doorman_R81", R.drawable.hnlms_karel_doorman_r81);
        photoMap.put("HSwMS_Dristigheten", R.drawable.hswms_dristigheten);
        photoMap.put("HSwMS_Gotland_1933", R.drawable.hswms_gotland_1933);
        photoMap.put("HTMS_Chakri_Naruebet", R.drawable.htms_chakri_naruebet);
        photoMap.put("INS_Vikramaditya", R.drawable.ins_vikramaditya);
        photoMap.put("INS_Vikrant_2013", R.drawable.ins_vikrant_2013);
        photoMap.put("INS_Vikrant", R.drawable.ins_vikrant);
        photoMap.put("INS_Viraat", R.drawable.ins_viraat);
        photoMap.put("Italian_aircraft_carrier_Aquila", R.drawable.italian_aircraft_carrier_aquila);
        photoMap.put("Italian_aircraft_carrier_Cavour_550", R.drawable.italian_aircraft_carrier_cavour_550);
        photoMap.put("Italian_aircraft_carrier_Giuseppe_Garibaldi_551", R.drawable.italian_aircraft_carrier_giuseppe_garibaldi_551);
        photoMap.put("Italian_aircraft_carrier_Sparviero", R.drawable.italian_aircraft_carrier_sparviero);
        photoMap.put("Japanese_aircraft_carrier_Akagi", R.drawable.japanese_aircraft_carrier_akagi);
        photoMap.put("Japanese_aircraft_carrier_Akitsu_Maru", R.drawable.japanese_aircraft_carrier_akitsu_maru);
        photoMap.put("Japanese_aircraft_carrier_Aso", R.drawable.japanese_aircraft_carrier_aso);
        photoMap.put("Japanese_aircraft_carrier_Chitose", R.drawable.japanese_aircraft_carrier_chitose);
        photoMap.put("Japanese_aircraft_carrier_Chuyo", R.drawable.japanese_aircraft_carrier_chuyo);
        photoMap.put("Japanese_aircraft_carrier_Hiryu", R.drawable.japanese_aircraft_carrier_hiryu);
        photoMap.put("Japanese_aircraft_carrier_Hosho", R.drawable.japanese_aircraft_carrier_hosho);
        photoMap.put("Japanese_aircraft_carrier_Ikoma", R.drawable.japanese_aircraft_carrier_ikoma);
        photoMap.put("Japanese_aircraft_carrier_Junyo", R.drawable.japanese_aircraft_carrier_junyo);
        photoMap.put("Japanese_aircraft_carrier_Kaga", R.drawable.japanese_aircraft_carrier_kaga);
        photoMap.put("Japanese_aircraft_carrier_Kaiyo", R.drawable.japanese_aircraft_carrier_kaiyo);
        photoMap.put("Japanese_aircraft_carrier_Kasagi", R.drawable.japanese_aircraft_carrier_kasagi);
        photoMap.put("Japanese_aircraft_carrier_Katsuragi", R.drawable.japanese_aircraft_carrier_katsuragi);
        photoMap.put("Japanese_aircraft_carrier_Kumano_Maru", R.drawable.japanese_aircraft_carrier_kumano_maru);
        photoMap.put("Japanese_aircraft_carrier_Ryuho", R.drawable.japanese_aircraft_carrier_ryuho);
        photoMap.put("Japanese_aircraft_carrier_Ryujo", R.drawable.japanese_aircraft_carrier_ryujo);
        photoMap.put("Japanese_aircraft_carrier_Shimane_Maru", R.drawable.japanese_aircraft_carrier_shimane_maru);
        photoMap.put("Japanese_aircraft_carrier_Shinyo", R.drawable.japanese_aircraft_carrier_shinyo);
        photoMap.put("Japanese_aircraft_carrier_Shoho", R.drawable.japanese_aircraft_carrier_shoho);
        photoMap.put("Japanese_aircraft_carrier_Shokaku", R.drawable.japanese_aircraft_carrier_shokaku);
        photoMap.put("Japanese_aircraft_carrier_Soryu", R.drawable.japanese_aircraft_carrier_soryu);
        photoMap.put("Japanese_aircraft_carrier_Taiho", R.drawable.japanese_aircraft_carrier_taiho);
        photoMap.put("Japanese_aircraft_carrier_Taiyo", R.drawable.japanese_aircraft_carrier_taiyo);
        photoMap.put("Japanese_aircraft_carrier_Unryu", R.drawable.japanese_aircraft_carrier_unryu);
        photoMap.put("Japanese_aircraft_carrier_Unyo", R.drawable.japanese_aircraft_carrier_unyo);
        photoMap.put("Japanese_aircraft_carrier_Yamashiro_Maru", R.drawable.japanese_aircraft_carrier_yamashiro_maru);
        photoMap.put("Japanese_aircraft_carrier_Zuiho", R.drawable.japanese_aircraft_carrier_zuiho);
        photoMap.put("Japanese_aircraft_carrier_Zuikaku", R.drawable.japanese_aircraft_carrier_zuikaku);
        photoMap.put("Japanese_battlecruiser_Amagi", R.drawable.japanese_battlecruiser_amagi);
        photoMap.put("Japanese_battleship_Hyuga", R.drawable.japanese_battleship_hyuga);
        photoMap.put("Japanese_submarine_I13", R.drawable.japanese_submarine_i13);
        photoMap.put("Japanese_submarine_I14", R.drawable.japanese_submarine_i14);
        photoMap.put("Japanese_submarine_I15", R.drawable.japanese_submarine_i15);
        photoMap.put("Japanese_submarine_I17", R.drawable.japanese_submarine_i17);
        photoMap.put("Japanese_submarine_I19", R.drawable.japanese_submarine_i19);
        photoMap.put("Japanese_submarine_I21", R.drawable.japanese_submarine_i21);
        photoMap.put("Japanese_submarine_I23", R.drawable.japanese_submarine_i23);
        photoMap.put("Japanese_submarine_I25", R.drawable.japanese_submarine_i25);
        photoMap.put("Japanese_submarine_I26", R.drawable.japanese_submarine_i26);
        photoMap.put("Japanese_submarine_I27", R.drawable.japanese_submarine_i27);
        photoMap.put("Japanese_submarine_I28", R.drawable.japanese_submarine_i28);
        photoMap.put("Japanese_submarine_I29", R.drawable.japanese_submarine_i29);
        photoMap.put("Japanese_submarine_I30", R.drawable.japanese_submarine_i30);
        photoMap.put("Japanese_submarine_I31", R.drawable.japanese_submarine_i31);
        photoMap.put("Japanese_submarine_I34", R.drawable.japanese_submarine_i34);
        photoMap.put("Japanese_submarine_I400", R.drawable.japanese_submarine_i400);
        photoMap.put("Japanese_submarine_I401", R.drawable.japanese_submarine_i401);
        photoMap.put("JDS_Izumo_DDH183", R.drawable.jds_izumo_ddh183);
        photoMap.put("MV_Alexia", R.drawable.mv_alexia);
        photoMap.put("MV_Ancylus", R.drawable.mv_ancylus);
        photoMap.put("MV_Empire_MacAlpine", R.drawable.mv_empire_macalpine);
        photoMap.put("MV_Empire_MacAndrew", R.drawable.mv_empire_macandrew);
        photoMap.put("MV_Empire_MacColl", R.drawable.mv_empire_maccoll);
        photoMap.put("MV_Empire_MacRae", R.drawable.mv_empire_macrae);
        photoMap.put("MV_Rapana", R.drawable.mv_rapana);
        photoMap.put("Russian_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov", R.drawable.russian_aircraft_carrier_admiral_of_the_fleet_of_the_soviet_union_kuznetsov);
        photoMap.put("Soviet_aircraft_carrier_Admiral_Gorshkov", R.drawable.soviet_aircraft_carrier_admiral_gorshkov);
        photoMap.put("Soviet_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov", R.drawable.soviet_aircraft_carrier_admiral_of_the_fleet_of_the_soviet_union_kuznetsov);
        photoMap.put("Soviet_aircraft_carrier_Kiev", R.drawable.soviet_aircraft_carrier_kiev);
        photoMap.put("Soviet_aircraft_carrier_Minsk", R.drawable.soviet_aircraft_carrier_minsk);
        photoMap.put("Soviet_aircraft_carrier_Novorossiysk", R.drawable.soviet_aircraft_carrier_novorossiysk);
        photoMap.put("Soviet_aircraft_carrier_Varyag", R.drawable.soviet_aircraft_carrier_varyag);
        photoMap.put("Soviet_helicopter_carrier_Leningrad", R.drawable.soviet_helicopter_carrier_leningrad);
        photoMap.put("Soviet_helicopter_carrier_Moskva", R.drawable.soviet_helicopter_carrier_moskva);
        photoMap.put("Spanish_aircraft_carrier_Dedalo", R.drawable.spanish_aircraft_carrier_dedalo);
        photoMap.put("Spanish_aircraft_carrier_Principe_de_Asturias", R.drawable.spanish_aircraft_carrier_principe_de_asturias);
        photoMap.put("Spanish_seaplane_carrier_Dedalo", R.drawable.spanish_seaplane_carrier_dedalo);
        photoMap.put("Spanish_ship_Juan_Carlos_I_L61", R.drawable.spanish_ship_juan_carlos_i_l61);
        photoMap.put("SS_Europa_1928", R.drawable.ss_europa_1928);
        photoMap.put("USS_Admiralty_Islands_CVE99", R.drawable.uss_admiralty_islands_cve99);
        photoMap.put("USS_Altamaha_CVE18", R.drawable.uss_altamaha_cve18);
        photoMap.put("USS_Altamaha_CVE6", R.drawable.uss_altamaha_cve6);
        photoMap.put("USS_America_CV66", R.drawable.uss_america_cv66);
        photoMap.put("USS_Antietam_CV36", R.drawable.uss_antietam_cv36);
        photoMap.put("USS_Anzio_CVE57", R.drawable.uss_anzio_cve57);
        photoMap.put("USS_Archer_BAVG1", R.drawable.uss_archer_bavg1);
        photoMap.put("USS_Attu_CVE102", R.drawable.uss_attu_cve102);
        photoMap.put("USS_Badoeng_Strait_CVE116", R.drawable.uss_badoeng_strait_cve116);
        photoMap.put("USS_Baffins_CVE35", R.drawable.uss_baffins_cve35);
        photoMap.put("USS_Bairoko_CVE115", R.drawable.uss_bairoko_cve115);
        photoMap.put("USS_Barnes_CVE20", R.drawable.uss_barnes_cve20);
        photoMap.put("USS_Barnes_CVE7", R.drawable.uss_barnes_cve7);
        photoMap.put("USS_Bastian_CVE37", R.drawable.uss_bastian_cve37);
        photoMap.put("USS_Bataan_CVL29", R.drawable.uss_bataan_cvl29);
        photoMap.put("USS_Belleau_Wood_CVL24", R.drawable.uss_belleau_wood_cvl24);
        photoMap.put("USS_Bennington_CV20", R.drawable.uss_bennington_cv20);
        photoMap.put("USS_Bismarck_Sea_CVE95", R.drawable.uss_bismarck_sea_cve95);
        photoMap.put("USS_Block_Island_CVE106", R.drawable.uss_block_island_cve106);
        photoMap.put("USS_Block_Island_CVE21", R.drawable.uss_block_island_cve21);
        photoMap.put("USS_Bogue_CVE9", R.drawable.uss_bogue_cve9);
        photoMap.put("USS_Bolinas_CVE36", R.drawable.uss_bolinas_cve36);
        photoMap.put("USS_Bon_Homme_Richard_CV31", R.drawable.uss_bon_homme_richard_cv31);
        photoMap.put("USS_Bougainville_CVE100", R.drawable.uss_bougainville_cve100);
        photoMap.put("USS_Boxer_CV21", R.drawable.uss_boxer_cv21);
        photoMap.put("USS_Breton_CVE10", R.drawable.uss_breton_cve10);
        photoMap.put("USS_Breton_CVE23", R.drawable.uss_breton_cve23);
        photoMap.put("USS_Bunker_Hill_CV17", R.drawable.uss_bunker_hill_cv17);
        photoMap.put("USS_Cabot_CVL28", R.drawable.uss_cabot_cvl28);
        photoMap.put("USS_Cape_Esperance_CVE88", R.drawable.uss_cape_esperance_cve88);
        photoMap.put("USS_Card_CVE11", R.drawable.uss_card_cve11);
        photoMap.put("USS_Carl_Vinson_CVN70", R.drawable.uss_carl_vinson_cvn70);
        photoMap.put("USS_Carnegie_CVE38", R.drawable.uss_carnegie_cve38);
        photoMap.put("USS_Casablanca_CVE55", R.drawable.uss_casablanca_cve55);
        photoMap.put("USS_Charger_CVE30", R.drawable.uss_charger_cve30);
        photoMap.put("USS_Chatham_CVE32", R.drawable.uss_chatham_cve32);
        photoMap.put("USS_Chenango_CVE28", R.drawable.uss_chenango_cve28);
        photoMap.put("USS_Constellation_CV64", R.drawable.uss_constellation_cv64);
        photoMap.put("USS_Copahee_CVE12", R.drawable.uss_copahee_cve12);
        photoMap.put("USS_Coral_Sea_CV43", R.drawable.uss_coral_sea_cv43);
        photoMap.put("USS_Cordova_CVE39", R.drawable.uss_cordova_cve39);
        photoMap.put("USS_Core_CVE13", R.drawable.uss_core_cve13);
        photoMap.put("USS_Corregidor_CVE58", R.drawable.uss_corregidor_cve58);
        photoMap.put("USS_Cowpens_CVL25", R.drawable.uss_cowpens_cvl25);
        photoMap.put("USS_Croatan_CVE14", R.drawable.uss_croatan_cve14);
        photoMap.put("USS_Croatan_CVE25", R.drawable.uss_croatan_cve25);
        photoMap.put("USS_Delgada_CVE40", R.drawable.uss_delgada_cve40);
        photoMap.put("USS_Dwight_D_Eisenhower_CVN69", R.drawable.uss_dwight_d_eisenhower_cvn69);
        photoMap.put("USS_Edisto_CVE41", R.drawable.uss_edisto_cve41);
        photoMap.put("USS_Enterprise_CV6", R.drawable.uss_enterprise_cv6);
        photoMap.put("USS_Enterprise_CVN65", R.drawable.uss_enterprise_cvn65);
        photoMap.put("USS_Enterprise_CVN80", R.drawable.uss_enterprise_cvn80);
        photoMap.put("USS_Essex_CV9", R.drawable.uss_essex_cv9);
        photoMap.put("USS_Estero_CVE42", R.drawable.uss_estero_cve42);
        photoMap.put("USS_Fanshaw_Bay_CVE70", R.drawable.uss_fanshaw_bay_cve70);
        photoMap.put("USS_Forrestal_CV59", R.drawable.uss_forrestal_cv59);
        photoMap.put("USS_Franklin_CV13", R.drawable.uss_franklin_cv13);
        photoMap.put("USS_Franklin_D_Roosevelt_CV42", R.drawable.uss_franklin_d_roosevelt_cv42);
        photoMap.put("USS_Gambier_Bay_CVE73", R.drawable.uss_gambier_bay_cve73);
        photoMap.put("USS_George_HW_Bush_CVN77", R.drawable.uss_george_hw_bush_cvn77);
        photoMap.put("USS_George_Washington_CVN73", R.drawable.uss_george_washington_cvn73);
        photoMap.put("USS_Gerald_R_Ford_CVN78", R.drawable.uss_gerald_r_ford_cvn78);
        photoMap.put("USS_Gilbert_Islands_CVE107", R.drawable.uss_gilbert_islands_cve107);
        photoMap.put("USS_Glacier_CVE33", R.drawable.uss_glacier_cve33);
        photoMap.put("USS_Guadalcanal_CVE60", R.drawable.uss_guadalcanal_cve60);
        photoMap.put("USS_Hamlin_CVE15", R.drawable.uss_hamlin_cve15);
        photoMap.put("USS_Hancock_CV19", R.drawable.uss_hancock_cv19);
        photoMap.put("USS_Harry_S_Truman_CVN75", R.drawable.uss_harry_s_truman_cvn75);
        photoMap.put("USS_Hoggatt_Bay_CVE75", R.drawable.uss_hoggatt_bay_cve75);
        photoMap.put("USS_Hollandia_CVE97", R.drawable.uss_hollandia_cve97);
        photoMap.put("USS_Hornet_CV12", R.drawable.uss_hornet_cv12);
        photoMap.put("USS_Hornet_CV8", R.drawable.uss_hornet_cv8);
        photoMap.put("USS_Independence_CV62", R.drawable.uss_independence_cv62);
        photoMap.put("USS_Independence_CVL22", R.drawable.uss_independence_cvl22);
        photoMap.put("USS_Intrepid_CV11", R.drawable.uss_intrepid_cv11);
        photoMap.put("USS_Iwo_Jima_CV46", R.drawable.uss_iwo_jima_cv46);
        photoMap.put("USS_Jamaica_CVE43", R.drawable.uss_jamaica_cve43);
        photoMap.put("USS_John_C_Stennis_CVN74", R.drawable.uss_john_c_stennis_cvn74);
        photoMap.put("USS_John_F_Kennedy_CV67", R.drawable.uss_john_f_kennedy_cv67);
        photoMap.put("USS_John_F_Kennedy_CVN79", R.drawable.uss_john_f_kennedy_cvn79);
        photoMap.put("USS_Kadashan_Bay_CVE76", R.drawable.uss_kadashan_bay_cve76);
        photoMap.put("USS_Kalinin_Bay_CVE68", R.drawable.uss_kalinin_bay_cve68);
        photoMap.put("USS_Kasaan_Bay_CVE69", R.drawable.uss_kasaan_bay_cve69);
        photoMap.put("USS_Kearsarge_CV33", R.drawable.uss_kearsarge_cv33);
        photoMap.put("USS_Keweenaw_CVE44", R.drawable.uss_keweenaw_cve44);
        photoMap.put("USS_Kitkun_Bay_CVE71", R.drawable.uss_kitkun_bay_cve71);
        photoMap.put("USS_Kitty_Hawk_CV63", R.drawable.uss_kitty_hawk_cv63);
        photoMap.put("USS_Kula_Gulf_CVE108", R.drawable.uss_kula_gulf_cve108);
        photoMap.put("USS_Kwajalein_CVE98", R.drawable.uss_kwajalein_cve98);
        photoMap.put("USS_Lake_Champlain_CV39", R.drawable.uss_lake_champlain_cv39);
        photoMap.put("USS_Langley_CV1", R.drawable.uss_langley_cv1);
        photoMap.put("USS_Langley_CV27", R.drawable.uss_langley_cv27);
        photoMap.put("USS_Lexington_CV16", R.drawable.uss_lexington_cv16);
        photoMap.put("USS_Lexington_CV2", R.drawable.uss_lexington_cv2);
        photoMap.put("USS_Leyte_CV32", R.drawable.uss_leyte_cv32);
        photoMap.put("USS_Liscome_Bay_CVE56", R.drawable.uss_liscome_bay_cve56);
        photoMap.put("USS_Long_Island_CVE1", R.drawable.uss_long_island_cve1);
        photoMap.put("USS_LST16", R.drawable.uss_lst16);
        photoMap.put("USS_LST525", R.drawable.uss_lst525);
        photoMap.put("USS_LST906", R.drawable.uss_lst906);
        photoMap.put("USS_Lunga_Point_CVE94", R.drawable.uss_lunga_point_cve94);
        photoMap.put("USS_Makassar_Strait_CVE91", R.drawable.uss_makassar_strait_cve91);
        photoMap.put("USS_Makin_Island_CVE93", R.drawable.uss_makin_island_cve93);
        photoMap.put("USS_Marcus_Island_CVE77", R.drawable.uss_marcus_island_cve77);
        photoMap.put("USS_Matanikau_CVE101", R.drawable.uss_matanikau_cve101);
        photoMap.put("USS_Midway_CV41", R.drawable.uss_midway_cv41);
        photoMap.put("USS_Midway_CVE63", R.drawable.uss_midway_cve63);
        photoMap.put("USS_Mindoro_CVE120", R.drawable.uss_mindoro_cve120);
        photoMap.put("USS_Mission_Bay_CVE59", R.drawable.uss_mission_bay_cve59);
        photoMap.put("USS_Monterey_CV26", R.drawable.uss_monterey_cv26);
        photoMap.put("USS_Munda_CVE104", R.drawable.uss_munda_cve104);
        photoMap.put("USS_Nassau_CVE16", R.drawable.uss_nassau_cve16);
        photoMap.put("USS_Natoma_Bay_CVE62", R.drawable.uss_natoma_bay_cve62);
        photoMap.put("USS_Nehenta_Bay_CVE74", R.drawable.uss_nehenta_bay_cve74);
        photoMap.put("USS_Niantic_CVE46", R.drawable.uss_niantic_cve46);
        photoMap.put("USS_Nimitz_CVN68", R.drawable.uss_nimitz_cvn68);
        photoMap.put("USS_Ommaney_Bay_CVE79", R.drawable.uss_ommaney_bay_cve79);
        photoMap.put("USS_Oriskany_CV34", R.drawable.uss_oriskany_cv34);
        photoMap.put("USS_Palau_CVE122", R.drawable.uss_palau_cve122);
        photoMap.put("USS_Perdido_CVE47", R.drawable.uss_perdido_cve47);
        photoMap.put("USS_Petrof_Bay_CVE80", R.drawable.uss_petrof_bay_cve80);
        photoMap.put("USS_Philippine_Sea_CV47", R.drawable.uss_philippine_sea_cv47);
        photoMap.put("USS_Point_Cruz_CVE119", R.drawable.uss_point_cruz_cve119);
        photoMap.put("USS_Prince_CVE45", R.drawable.uss_prince_cve45);
        photoMap.put("USS_Princeton_CV37", R.drawable.uss_princeton_cv37);
        photoMap.put("USS_Princeton_CVL23", R.drawable.uss_princeton_cvl23);
        photoMap.put("USS_Prince_William_CVE19", R.drawable.uss_prince_william_cve19);
        photoMap.put("USS_Prince_William_CVE31", R.drawable.uss_prince_william_cve31);
        photoMap.put("USS_Puget_Sound_CVE113", R.drawable.uss_puget_sound_cve113);
        photoMap.put("USS_Pybus_CVE34", R.drawable.uss_pybus_cve34);
        photoMap.put("USS_Rabaul_CVE121", R.drawable.uss_rabaul_cve121);
        photoMap.put("USS_Randolph_CV15", R.drawable.uss_randolph_cv15);
        photoMap.put("USS_Ranger_CV4", R.drawable.uss_ranger_cv4);
        photoMap.put("USS_Ranger_CV61", R.drawable.uss_ranger_cv61);
        photoMap.put("USS_Rendova_CVE114", R.drawable.uss_rendova_cve114);
        photoMap.put("USS_Reprisal_CV35", R.drawable.uss_reprisal_cv35);
        photoMap.put("USS_Roi_CVE103", R.drawable.uss_roi_cve103);
        photoMap.put("USS_Ronald_Reagan_CVN76", R.drawable.uss_ronald_reagan_cvn76);
        photoMap.put("USS_Rudyerd_Bay_CVE81", R.drawable.uss_rudyerd_bay_cve81);
        photoMap.put("USS_Sable_IX81", R.drawable.uss_sable_ix81);
        photoMap.put("USS_Saginaw_Bay_CVE82", R.drawable.uss_saginaw_bay_cve82);
        photoMap.put("USS_Saidor_CVE117", R.drawable.uss_saidor_cve117);
        photoMap.put("USS_Saipan_CVL48", R.drawable.uss_saipan_cvl48);
        photoMap.put("USS_Salamaua_CVE96", R.drawable.uss_salamaua_cve96);
        photoMap.put("USS_Salerno_Bay_CVE110", R.drawable.uss_salerno_bay_cve110);
        photoMap.put("USS_Sangamon_CVE26", R.drawable.uss_sangamon_cve26);
        photoMap.put("USS_San_Jacinto_CVL30", R.drawable.uss_san_jacinto_cvl30);
        photoMap.put("USS_Santee_CVE29", R.drawable.uss_santee_cve29);
        photoMap.put("USS_Saratoga_CV3", R.drawable.uss_saratoga_cv3);
        photoMap.put("USS_Saratoga_CV60", R.drawable.uss_saratoga_cv60);
        photoMap.put("USS_Sargent_Bay_CVE83", R.drawable.uss_sargent_bay_cve83);
        photoMap.put("USS_Savo_Island_CVE78", R.drawable.uss_savo_island_cve78);
        photoMap.put("USS_Shamrock_Bay_CVE84", R.drawable.uss_shamrock_bay_cve84);
        photoMap.put("USS_ShangriLa_CV38", R.drawable.uss_shangrila_cv38);
        photoMap.put("USS_Shipley_Bay_CVE85", R.drawable.uss_shipley_bay_cve85);
        photoMap.put("USS_Siboney_CVE112", R.drawable.uss_siboney_cve112);
        photoMap.put("USS_Sicily_CVE118", R.drawable.uss_sicily_cve118);
        photoMap.put("USS_Sitkoh_Bay_CVE86", R.drawable.uss_sitkoh_bay_cve86);
        photoMap.put("USS_Solomons_CVE67", R.drawable.uss_solomons_cve67);
        photoMap.put("USS_St_Andrews_CVE49", R.drawable.uss_st_andrews_cve49);
        photoMap.put("USS_Steamer_Bay_CVE87", R.drawable.uss_steamer_bay_cve87);
        photoMap.put("USS_St_George_CVE17", R.drawable.uss_st_george_cve17);
        photoMap.put("USS_St_Joseph_CVE50", R.drawable.uss_st_joseph_cve50);
        photoMap.put("USS_St_Lo_CVE63", R.drawable.uss_st_lo_cve63);
        photoMap.put("USS_St_Simon_CVE51", R.drawable.uss_st_simon_cve51);
        photoMap.put("USS_Suwannee_CVE27", R.drawable.uss_suwannee_cve27);
        photoMap.put("USS_Takanis_Bay_CVE89", R.drawable.uss_takanis_bay_cve89);
        photoMap.put("USS_Tarawa_CV40", R.drawable.uss_tarawa_cv40);
        photoMap.put("USS_Theodore_Roosevelt_CVN71", R.drawable.uss_theodore_roosevelt_cvn71);
        photoMap.put("USS_Thetis_Bay_CVE90", R.drawable.uss_thetis_bay_cve90);
        photoMap.put("USS_Ticonderoga_CV14", R.drawable.uss_ticonderoga_cv14);
        photoMap.put("USS_Tinian_CVE123", R.drawable.uss_tinian_cve123);
        photoMap.put("USS_Tripoli_CVE64", R.drawable.uss_tripoli_cve64);
        photoMap.put("USS_Tulagi_CVE72", R.drawable.uss_tulagi_cve72);
        photoMap.put("USS_United_States_CV58", R.drawable.uss_united_states_cv58);
        photoMap.put("USS_Valley_Forge_CV45", R.drawable.uss_valley_forge_cv45);
        photoMap.put("USS_Vella_Gulf_CVE111", R.drawable.uss_vella_gulf_cve111);
        photoMap.put("USS_Vermillion_CVE52", R.drawable.uss_vermillion_cve52);
        //photoMap.put("uss_wake_island_cve65", R.drawable.uss_wake_island_cve65);
        //photoMap.put("uss_wake_island_cve65", R.drawable.uss_wake_island_cve65);
        photoMap.put("USS_Wake_Island_CVE65", R.drawable.uss_wake_island_cve65);
        photoMap.put("USS_Wasp_CV18", R.drawable.uss_wasp_cv18);
        photoMap.put("USS_Wasp_CV7", R.drawable.uss_wasp_cv7);
        photoMap.put("USS_White_Plains_CVE66", R.drawable.uss_white_plains_cve66);
        photoMap.put("USS_Willapa_CVE53", R.drawable.uss_willapa_cve53);
        photoMap.put("USS_Windham_Bay_CVE92", R.drawable.uss_windham_bay_cve92);
        photoMap.put("USS_Wolverine_IX64", R.drawable.uss_wolverine_ix64);
        photoMap.put("USS_Wright_CVL49", R.drawable.uss_wright_cvl49);
        photoMap.put("USS_Yorktown_CV10", R.drawable.uss_yorktown_cv10);
        photoMap.put("USS_Yorktown_CV5", R.drawable.uss_yorktown_cv5);
        photoMap.put("carrier", R.drawable.carrier);

        carrierMap.put("ARA_Independencia_1958", R.string.ARA_Independencia_1958);
        carrierMap.put("ARA_Veinticinco_de_Mayo_V2", R.string.ARA_Veinticinco_de_Mayo_V2);
        carrierMap.put("Brazilian_aircraft_carrier_Minas_Gerais", R.string.Brazilian_aircraft_carrier_Minas_Gerais);
        carrierMap.put("Chinese_aircraft_carrier_Liaoning", R.string.Chinese_aircraft_carrier_Liaoning);
        carrierMap.put("French_aircraft_carrier_Arromanches_R95", R.string.French_aircraft_carrier_Arromanches_R95);
        carrierMap.put("French_aircraft_carrier_Bois_Belleau", R.string.French_aircraft_carrier_Bois_Belleau);
        carrierMap.put("French_aircraft_carrier_Clemenceau_R98", R.string.French_aircraft_carrier_Clemenceau_R98);
        carrierMap.put("French_aircraft_carrier_Charles_de_Gaulle_R91", R.string.French_aircraft_carrier_Charles_de_Gaulle_R91);
        carrierMap.put("French_aircraft_carrier_Dixmude", R.string.French_aircraft_carrier_Dixmude);
        carrierMap.put("French_aircraft_carrier_Foch_R99", R.string.French_aircraft_carrier_Foch_R99);
        carrierMap.put("French_aircraft_carrier_Joffre", R.string.French_aircraft_carrier_Joffre);
        carrierMap.put("French_aircraft_carrier_La_Fayette_R96", R.string.French_aircraft_carrier_La_Fayette_R96);
        carrierMap.put("French_aircraft_carrier_Verdun", R.string.French_aircraft_carrier_Verdun);
        carrierMap.put("French_seaplane_carrier_Commandant_Teste", R.string.French_seaplane_carrier_Commandant_Teste);
        carrierMap.put("French_seaplane_carrier_Foudre", R.string.French_seaplane_carrier_Foudre);
        carrierMap.put("French_submarine_Surcouf", R.string.French_submarine_Surcouf);
        carrierMap.put("German_aircraft_carrier_Graf_Zeppelin", R.string.German_aircraft_carrier_Graf_Zeppelin);
        carrierMap.put("German_cruiser_Seydlitz", R.string.German_cruiser_Seydlitz);
        carrierMap.put("HMAS_Albatross_1928", R.string.HMAS_Albatross_1928);
        carrierMap.put("HMAS_Melbourne_R21", R.string.HMAS_Melbourne_R21);
        carrierMap.put("HMAS_Sydney_R17", R.string.HMAS_Sydney_R17);
        carrierMap.put("HMAS_Vengeance_R71", R.string.HMAS_Vengeance_R71);
        carrierMap.put("HMCS_Bonaventure_CVL_22", R.string.HMCS_Bonaventure_CVL_22);
        carrierMap.put("HMCS_Magnificent_CVL21", R.string.HMCS_Magnificent_CVL21);
        carrierMap.put("HMCS_Warrior_R31", R.string.HMCS_Warrior_R31);
        carrierMap.put("HMS_Activity_D94", R.string.HMS_Activity_D94);
        carrierMap.put("HMS_Africa", R.string.HMS_Africa);
        carrierMap.put("HMS_Albion_R07", R.string.HMS_Albion_R07);
        carrierMap.put("HMS_Ameer_D01", R.string.HMS_Ameer_D01);
        carrierMap.put("HMS_Arbiter_D31", R.string.HMS_Arbiter_D31);
        carrierMap.put("HMS_Archer_D78", R.string.HMS_Archer_D78);
        carrierMap.put("HMS_Argus_I49", R.string.HMS_Argus_I49);
        carrierMap.put("HMS_Ark_Royal_1914", R.string.HMS_Ark_Royal_1914);
        carrierMap.put("HMS_Ark_Royal_91", R.string.HMS_Ark_Royal_91);
        carrierMap.put("HMS_Ark_Royal_R07", R.string.HMS_Ark_Royal_R07);
        carrierMap.put("HMS_Ark_Royal_R09", R.string.HMS_Ark_Royal_R09);
        carrierMap.put("HMS_Atheling_D51", R.string.HMS_Atheling_D51);
        carrierMap.put("HMS_Attacker_D02", R.string.HMS_Attacker_D02);
        carrierMap.put("HMS_Audacity_D10", R.string.HMS_Audacity_D10);
        carrierMap.put("HMS_Avenger_D14", R.string.HMS_Avenger_D14);
        carrierMap.put("HMS_Battler_D18", R.string.HMS_Battler_D18);
        carrierMap.put("HMS_Begum_D38", R.string.HMS_Begum_D38);
        carrierMap.put("HMS_Benmy_Chree", R.string.HMS_Benmy_Chree);
        carrierMap.put("HMS_Biter_D97", R.string.HMS_Biter_D97);
        carrierMap.put("HMS_Bulwark_R08", R.string.HMS_Bulwark_R08);
        carrierMap.put("HMS_Campania_1914", R.string.HMS_Campania_1914);
        carrierMap.put("HMS_Campania_D48", R.string.HMS_Campania_D48);
        carrierMap.put("HMS_Chaser_D32", R.string.HMS_Chaser_D32);
        carrierMap.put("HMS_Colossus_R15", R.string.HMS_Colossus_R15);
        carrierMap.put("HMS_Courageous_50", R.string.HMS_Courageous_50);
        carrierMap.put("HMS_Dasher_D37", R.string.HMS_Dasher_D37);
        carrierMap.put("HMS_Eagle_1918", R.string.HMS_Eagle_1918);
        carrierMap.put("HMS_Eagle_R05", R.string.HMS_Eagle_R05);
        carrierMap.put("HMS_Emperor_D98", R.string.HMS_Emperor_D98);
        carrierMap.put("HMS_Empress_D42", R.string.HMS_Empress_D42);
        carrierMap.put("HMS_Fencer_D64", R.string.HMS_Fencer_D64);
        carrierMap.put("HMS_Formidable_67", R.string.HMS_Formidable_67);
        carrierMap.put("HMS_Furious_47", R.string.HMS_Furious_47);
        carrierMap.put("HMS_Glorious", R.string.HMS_Glorious);
        carrierMap.put("HMS_Glory_R62", R.string.HMS_Glory_R62);
        carrierMap.put("HMS_Hermes_95", R.string.HMS_Hermes_95);
        carrierMap.put("HMS_Hermes_R12", R.string.HMS_Hermes_R12);
        carrierMap.put("HMS_Hunter_D80", R.string.HMS_Hunter_D80);
        carrierMap.put("HMS_Illustrious_87", R.string.HMS_Illustrious_87);
        carrierMap.put("HMS_Illustrious_R06", R.string.HMS_Illustrious_R06);
        carrierMap.put("HMS_Implacable_R86", R.string.HMS_Implacable_R86);
        carrierMap.put("HMS_Indefatigable_R10", R.string.HMS_Indefatigable_R10);
        carrierMap.put("HMS_Indomitable_92", R.string.HMS_Indomitable_92);
        carrierMap.put("HMS_Invincible_R05", R.string.HMS_Invincible_R05);
        carrierMap.put("HMS_Khedive_D62", R.string.HMS_Khedive_D62);
        carrierMap.put("HMS_M2", R.string.HMS_M2);
        carrierMap.put("HMS_Manxman_1916", R.string.HMS_Manxman_1916);
        carrierMap.put("HMS_Nabob_D77", R.string.HMS_Nabob_D77);
        carrierMap.put("HMS_Nairana_1917", R.string.HMS_Nairana_1917);
        carrierMap.put("HMS_Nairana_D05", R.string.HMS_Nairana_D05);
        carrierMap.put("HMS_Ocean_L12", R.string.HMS_Ocean_L12);
        carrierMap.put("HMS_Ocean_R68", R.string.HMS_Ocean_R68);
        carrierMap.put("HMS_Patroller_D07", R.string.HMS_Patroller_D07);
        carrierMap.put("HMS_Pegasus_1917", R.string.HMS_Pegasus_1917);
        carrierMap.put("HMS_Powerful_R95", R.string.HMS_Powerful_R95);
        carrierMap.put("HMS_Premier_D23", R.string.HMS_Premier_D23);
        carrierMap.put("HMS_Prince_of_Wales_R09", R.string.HMS_Prince_of_Wales_R09);
        carrierMap.put("HMS_Puncher_D79", R.string.HMS_Puncher_D79);
        carrierMap.put("HMS_Pursuer_D73", R.string.HMS_Pursuer_D73);
        carrierMap.put("HMS_Queen_D19", R.string.HMS_Queen_D19);
        carrierMap.put("HMS_Queen_Elizabeth_R08", R.string.HMS_Queen_Elizabeth_R08);
        carrierMap.put("HMS_Rajah_D10", R.string.HMS_Rajah_D10);
        carrierMap.put("HMS_Ranee_D03", R.string.HMS_Ranee_D03);
        carrierMap.put("HMS_Ravager_D70", R.string.HMS_Ravager_D70);
        carrierMap.put("HMS_Ruler_D72", R.string.HMS_Ruler_D72);
        carrierMap.put("HMS_Searcher_D40", R.string.HMS_Searcher_D40);
        carrierMap.put("HMS_Shah_D21", R.string.HMS_Shah_D21);
        carrierMap.put("HMS_Slinger_D26", R.string.HMS_Slinger_D26);
        carrierMap.put("HMS_Smiter_D55", R.string.HMS_Smiter_D55);
        carrierMap.put("HMS_Speaker_D90", R.string.HMS_Speaker_D90);
        carrierMap.put("HMS_Stalker_D91", R.string.HMS_Stalker_D91);
        carrierMap.put("HMS_Striker_D12", R.string.HMS_Striker_D12);
        carrierMap.put("HMS_Terrible_R93", R.string.HMS_Terrible_R93);
        carrierMap.put("HMS_Thane_D48", R.string.HMS_Thane_D48);
        carrierMap.put("HMS_Tracker_D24", R.string.HMS_Tracker_D24);
        carrierMap.put("HMS_Trouncer_D85", R.string.HMS_Trouncer_D85);
        carrierMap.put("HMS_Trumpeter_D09", R.string.HMS_Trumpeter_D09);
        carrierMap.put("HMS_Unicorn_I72", R.string.HMS_Unicorn_I72);
        carrierMap.put("HMS_Venerable_R63", R.string.HMS_Venerable_R63);
        carrierMap.put("HMS_Vengeance_R71", R.string.HMS_Vengeance_R71);
        carrierMap.put("HMS_Victorious_R38", R.string.HMS_Victorious_R38);
        carrierMap.put("HMS_Vindex_1915", R.string.HMS_Vindex_1915);
        carrierMap.put("HMS_Vindex_D15", R.string.HMS_Vindex_D15);
        carrierMap.put("HMS_Warrior_R31", R.string.HMS_Warrior_R31);
        carrierMap.put("HNLMS_Karel_Doorman_QH1", R.string.HNLMS_Karel_Doorman_QH1);
        carrierMap.put("HNLMS_Karel_Doorman_R81", R.string.HNLMS_Karel_Doorman_R81);
        carrierMap.put("HSwMS_Dristigheten", R.string.HSwMS_Dristigheten);
        carrierMap.put("HSwMS_Gotland_1933", R.string.HSwMS_Gotland_1933);
        carrierMap.put("HTMS_Chakri_Naruebet", R.string.HTMS_Chakri_Naruebet);
        carrierMap.put("INS_Vikramaditya", R.string.INS_Vikramaditya);
        carrierMap.put("INS_Vikrant_2013", R.string.INS_Vikrant_2013);
        carrierMap.put("INS_Vikrant", R.string.INS_Vikrant);
        carrierMap.put("INS_Viraat", R.string.INS_Viraat);
        carrierMap.put("Italian_aircraft_carrier_Aquila", R.string.Italian_aircraft_carrier_Aquila);
        carrierMap.put("Italian_aircraft_carrier_Cavour_550", R.string.Italian_aircraft_carrier_Cavour_550);
        carrierMap.put("Italian_aircraft_carrier_Giuseppe_Garibaldi_551", R.string.Italian_aircraft_carrier_Giuseppe_Garibaldi_551);
        carrierMap.put("Italian_aircraft_carrier_Sparviero", R.string.Italian_aircraft_carrier_Sparviero);
        carrierMap.put("Italian_seaplane_tender_Giuseppe_Miraglia", R.string.Italian_seaplane_tender_Giuseppe_Miraglia);
        carrierMap.put("Japanese_aircraft_carrier_Akagi", R.string.Japanese_aircraft_carrier_Akagi);
        carrierMap.put("Japanese_aircraft_carrier_Akitsu_Maru", R.string.Japanese_aircraft_carrier_Akitsu_Maru);
        carrierMap.put("Japanese_aircraft_carrier_Amagi", R.string.Japanese_aircraft_carrier_Amagi);
        carrierMap.put("Japanese_aircraft_carrier_Aso", R.string.Japanese_aircraft_carrier_Aso);
        carrierMap.put("Japanese_aircraft_carrier_Chitose", R.string.Japanese_aircraft_carrier_Chitose);
        carrierMap.put("Japanese_aircraft_carrier_Chiyoda", R.string.Japanese_aircraft_carrier_Chiyoda);
        carrierMap.put("Japanese_aircraft_carrier_Ikoma", R.string.Japanese_aircraft_carrier_Ikoma);
        carrierMap.put("Japanese_aircraft_carrier_Kaga", R.string.Japanese_aircraft_carrier_Kaga);
        carrierMap.put("Japanese_aircraft_carrier_Kaiyo", R.string.Japanese_aircraft_carrier_Kaiyo);
        carrierMap.put("Japanese_aircraft_carrier_Kasagi", R.string.Japanese_aircraft_carrier_Kasagi);
        carrierMap.put("Japanese_aircraft_carrier_Katsuragi", R.string.Japanese_aircraft_carrier_Katsuragi);
        carrierMap.put("Japanese_aircraft_carrier_Kumano_Maru", R.string.Japanese_aircraft_carrier_Kumano_Maru);
        carrierMap.put("Japanese_aircraft_carrier_Shimane_Maru", R.string.Japanese_aircraft_carrier_Shimane_Maru);
        carrierMap.put("Japanese_aircraft_carrier_Shinano", R.string.Japanese_aircraft_carrier_Shinano);
        carrierMap.put("Japanese_aircraft_carrier_Shinyo", R.string.Japanese_aircraft_carrier_Shinyo);
        carrierMap.put("Japanese_aircraft_carrier_Unyo", R.string.Japanese_aircraft_carrier_Unyo);
        carrierMap.put("Japanese_aircraft_carrier_Yamashiro_Maru", R.string.Japanese_aircraft_carrier_Yamashiro_Maru);
        carrierMap.put("Japanese_aircraft_carrier_Zuikaku", R.string.Japanese_aircraft_carrier_Zuikaku);
        carrierMap.put("Japanese_battlecruiser_Amagi", R.string.Japanese_battlecruiser_Amagi);
        carrierMap.put("Japanese_submarine_I13", R.string.Japanese_submarine_I13);
        carrierMap.put("Japanese_submarine_I14", R.string.Japanese_submarine_I14);
        carrierMap.put("Japanese_submarine_I15", R.string.Japanese_submarine_I15);
        carrierMap.put("Japanese_submarine_I17", R.string.Japanese_submarine_I17);
        carrierMap.put("Japanese_submarine_I19", R.string.Japanese_submarine_I19);
        carrierMap.put("Japanese_submarine_I21", R.string.Japanese_submarine_I21);
        carrierMap.put("Japanese_submarine_I23", R.string.Japanese_submarine_I23);
        carrierMap.put("Japanese_submarine_I25", R.string.Japanese_submarine_I25);
        carrierMap.put("Japanese_submarine_I26", R.string.Japanese_submarine_I26);
        carrierMap.put("Japanese_submarine_I27", R.string.Japanese_submarine_I27);
        carrierMap.put("Japanese_submarine_I28", R.string.Japanese_submarine_I28);
        carrierMap.put("Japanese_submarine_I29", R.string.Japanese_submarine_I29);
        carrierMap.put("Japanese_submarine_I30", R.string.Japanese_submarine_I30);
        carrierMap.put("Japanese_submarine_I31", R.string.Japanese_submarine_I31);
        carrierMap.put("Japanese_submarine_I34", R.string.Japanese_submarine_I34);
        carrierMap.put("Japanese_submarine_I400", R.string.Japanese_submarine_I400);
        carrierMap.put("Japanese_submarine_I401", R.string.Japanese_submarine_I401);
        carrierMap.put("Japanese_Submarine_I402", R.string.Japanese_Submarine_I402);
        carrierMap.put("JDS_Izumo_DDH183", R.string.JDS_Izumo_DDH183);
        carrierMap.put("MV_Acavus", R.string.MV_Acavus);
        carrierMap.put("MV_Adula", R.string.MV_Adula);
        carrierMap.put("MV_Alexia", R.string.MV_Alexia);
        carrierMap.put("MV_Amastra", R.string.MV_Amastra);
        carrierMap.put("MV_Ancylus", R.string.MV_Ancylus);
        carrierMap.put("MV_Empire_MacAlpine", R.string.MV_Empire_MacAlpine);
        carrierMap.put("MV_Empire_MacAndrew", R.string.MV_Empire_MacAndrew);
        carrierMap.put("MV_Empire_MacCabe", R.string.MV_Empire_MacCabe);
        carrierMap.put("MV_Empire_MacCallum", R.string.MV_Empire_MacCallum);
        carrierMap.put("MV_Empire_MacColl", R.string.MV_Empire_MacColl);
        carrierMap.put("MV_Empire_MacDermott", R.string.MV_Empire_MacDermott);
        carrierMap.put("MV_Empire_MacKay", R.string.MV_Empire_MacKay);
        carrierMap.put("MV_Empire_MacKendrick", R.string.MV_Empire_MacKendrick);
        carrierMap.put("MV_Empire_MacMahon", R.string.MV_Empire_MacMahon);
        carrierMap.put("MV_Empire_MacRae", R.string.MV_Empire_MacRae);
        carrierMap.put("MV_Gadila", R.string.MV_Gadila);
        carrierMap.put("MV_Macoma", R.string.MV_Macoma);
        carrierMap.put("MV_Miralda", R.string.MV_Miralda);
        carrierMap.put("MV_Rapana", R.string.MV_Rapana);
        carrierMap.put("PH_75", R.string.PH_75);
        carrierMap.put("Russian_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov", R.string.Russian_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov);
        carrierMap.put("Soviet_aircraft_carrier_Admiral_Gorshkov", R.string.Soviet_aircraft_carrier_Admiral_Gorshkov);
        carrierMap.put("Soviet_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov", R.string.Soviet_aircraft_carrier_Admiral_of_the_Fleet_of_the_Soviet_Union_Kuznetsov);
        carrierMap.put("Soviet_aircraft_carrier_Kiev", R.string.Soviet_aircraft_carrier_Kiev);
        carrierMap.put("Soviet_aircraft_carrier_Minsk", R.string.Soviet_aircraft_carrier_Minsk);
        carrierMap.put("Soviet_aircraft_carrier_Novorossiysk", R.string.Soviet_aircraft_carrier_Novorossiysk);
        carrierMap.put("Soviet_aircraft_carrier_Ulyanovsk", R.string.Soviet_aircraft_carrier_Ulyanovsk);
        carrierMap.put("Soviet_aircraft_carrier_Varyag", R.string.Soviet_aircraft_carrier_Varyag);
        carrierMap.put("Soviet_helicopter_carrier_Leningrad", R.string.Soviet_helicopter_carrier_Leningrad);
        carrierMap.put("Soviet_helicopter_carrier_Moskva", R.string.Soviet_helicopter_carrier_Moskva);
        carrierMap.put("Spanish_aircraft_carrier_Principe_de_Asturias", R.string.Spanish_aircraft_carrier_Principe_de_Asturias);
        carrierMap.put("Spanish_ship_Juan_Carlos_I_L61", R.string.Spanish_ship_Juan_Carlos_I_L61);
        carrierMap.put("SS_Europa_1928", R.string.SS_Europa_1928);
        carrierMap.put("Type_AM_submarine", R.string.Type_AM_submarine);
        carrierMap.put("Type_B1_submarine", R.string.Type_B1_submarine);
        carrierMap.put("USS_Abraham_Lincoln_CVN72", R.string.USS_Abraham_Lincoln_CVN72);
        carrierMap.put("USS_Admiralty_Islands_CVE99", R.string.USS_Admiralty_Islands_CVE99);
        carrierMap.put("USS_Altamaha_CVE18", R.string.USS_Altamaha_CVE18);
        carrierMap.put("USS_Altamaha_CVE6", R.string.USS_Altamaha_CVE6);
        carrierMap.put("USS_America_CV66", R.string.USS_America_CV66);
        carrierMap.put("USS_Antietam_CV36", R.string.USS_Antietam_CV36);
        carrierMap.put("USS_Anzio_CVE57", R.string.USS_Anzio_CVE57);
        carrierMap.put("USS_Archer_BAVG1", R.string.USS_Archer_BAVG1);
        carrierMap.put("USS_Attu_CVE102", R.string.USS_Attu_CVE102);
        carrierMap.put("USS_Badoeng_Strait_CVE116", R.string.USS_Badoeng_Strait_CVE116);
        carrierMap.put("USS_Baffins_CVE35", R.string.USS_Baffins_CVE35);
        carrierMap.put("USS_Bairoko_CVE115", R.string.USS_Bairoko_CVE115);
        carrierMap.put("USS_Barnes_CVE20", R.string.USS_Barnes_CVE20);
        carrierMap.put("USS_Barnes_CVE7", R.string.USS_Barnes_CVE7);
        carrierMap.put("USS_Bastian_CVE37", R.string.USS_Bastian_CVE37);
        carrierMap.put("USS_Bataan_CVL29", R.string.USS_Bataan_CVL29);
        carrierMap.put("USS_Belleau_Wood_CVL24", R.string.USS_Belleau_Wood_CVL24);
        carrierMap.put("USS_Bennington_CV20", R.string.USS_Bennington_CV20);
        carrierMap.put("USS_Bismarck_Sea_CVE95", R.string.USS_Bismarck_Sea_CVE95);
        carrierMap.put("USS_Block_Island_CVE106", R.string.USS_Block_Island_CVE106);
        carrierMap.put("USS_Block_Island_CVE21", R.string.USS_Block_Island_CVE21);
        carrierMap.put("USS_Bogue_CVE9", R.string.USS_Bogue_CVE9);
        carrierMap.put("USS_Bolinas_CVE36", R.string.USS_Bolinas_CVE36);
        carrierMap.put("USS_Bon_Homme_Richard_CV31", R.string.USS_Bon_Homme_Richard_CV31);
        carrierMap.put("USS_Bougainville_CVE100", R.string.USS_Bougainville_CVE100);
        carrierMap.put("USS_Boxer_CV21", R.string.USS_Boxer_CV21);
        carrierMap.put("USS_Breton_CVE10", R.string.USS_Breton_CVE10);
        carrierMap.put("USS_Breton_CVE23", R.string.USS_Breton_CVE23);
        carrierMap.put("USS_Bunker_Hill_CV17", R.string.USS_Bunker_Hill_CV17);
        carrierMap.put("USS_Cabot_CVL28", R.string.USS_Cabot_CVL28);
        carrierMap.put("USS_Cape_Esperance_CVE88", R.string.USS_Cape_Esperance_CVE88);
        carrierMap.put("USS_Cape_Gloucester_CVE109", R.string.USS_Cape_Gloucester_CVE109);
        carrierMap.put("USS_Card_CVE11", R.string.USS_Card_CVE11);
        carrierMap.put("USS_Carl_Vinson_CVN70", R.string.USS_Carl_Vinson_CVN70);
        carrierMap.put("USS_Carnegie_CVE38", R.string.USS_Carnegie_CVE38);
        carrierMap.put("USS_Casablanca_CVE55", R.string.USS_Casablanca_CVE55);
        carrierMap.put("USS_Charger_CVE30", R.string.USS_Charger_CVE30);
        carrierMap.put("USS_Chatham_CVE32", R.string.USS_Chatham_CVE32);
        carrierMap.put("USS_Chenango_CVE28", R.string.USS_Chenango_CVE28);
        carrierMap.put("USS_Constellation_CV64", R.string.USS_Constellation_CV64);
        carrierMap.put("USS_Copahee_CVE12", R.string.USS_Copahee_CVE12);
        carrierMap.put("USS_Coral_Sea_CV43", R.string.USS_Coral_Sea_CV43);
        carrierMap.put("USS_Cordova_CVE39", R.string.USS_Cordova_CVE39);
        carrierMap.put("USS_Core_CVE13", R.string.USS_Core_CVE13);
        carrierMap.put("USS_Corregidor_CVE58", R.string.USS_Corregidor_CVE58);
        carrierMap.put("USS_Cowpens_CVL25", R.string.USS_Cowpens_CVL25);
        carrierMap.put("USS_Croatan_CVE14", R.string.USS_Croatan_CVE14);
        carrierMap.put("USS_Croatan_CVE25", R.string.USS_Croatan_CVE25);
        carrierMap.put("USS_Delgada_CVE40", R.string.USS_Delgada_CVE40);
        carrierMap.put("USS_Dwight_D_Eisenhower_CVN69", R.string.USS_Dwight_D_Eisenhower_CVN69);
        carrierMap.put("USS_Edisto_CVE41", R.string.USS_Edisto_CVE41);
        carrierMap.put("USS_Enterprise_CV6", R.string.USS_Enterprise_CV6);
        carrierMap.put("USS_Enterprise_CVN65", R.string.USS_Enterprise_CVN65);
        carrierMap.put("USS_Enterprise_CVN80", R.string.USS_Enterprise_CVN80);
        carrierMap.put("USS_Essex_CV9", R.string.USS_Essex_CV9);
        carrierMap.put("USS_Estero_CVE42", R.string.USS_Estero_CVE42);
        carrierMap.put("USS_Fanshaw_Bay_CVE70", R.string.USS_Fanshaw_Bay_CVE70);
        carrierMap.put("USS_Forrestal_CV59", R.string.USS_Forrestal_CV59);
        carrierMap.put("USS_Franklin_CV13", R.string.USS_Franklin_CV13);
        carrierMap.put("USS_Franklin_D_Roosevelt_CV42", R.string.USS_Franklin_D_Roosevelt_CV42);
        carrierMap.put("USS_Gambier_Bay_CVE73", R.string.USS_Gambier_Bay_CVE73);
        carrierMap.put("USS_George_HW_Bush_CVN77", R.string.USS_George_HW_Bush_CVN77);
        carrierMap.put("USS_George_Washington_CVN73", R.string.USS_George_Washington_CVN73);
        carrierMap.put("USS_Gerald_R_Ford_CVN78", R.string.USS_Gerald_R_Ford_CVN78);
        carrierMap.put("USS_Gilbert_Islands_CVE107", R.string.USS_Gilbert_Islands_CVE107);
        carrierMap.put("USS_Glacier_CVE33", R.string.USS_Glacier_CVE33);
        carrierMap.put("USS_Guadalcanal_CVE60", R.string.USS_Guadalcanal_CVE60);
        carrierMap.put("USS_Hamlin_CVE15", R.string.USS_Hamlin_CVE15);
        carrierMap.put("USS_Hancock_CV19", R.string.USS_Hancock_CV19);
        carrierMap.put("USS_Harry_S_Truman_CVN75", R.string.USS_Harry_S_Truman_CVN75);
        carrierMap.put("USS_Hoggatt_Bay_CVE75", R.string.USS_Hoggatt_Bay_CVE75);
        carrierMap.put("USS_Hollandia_CVE97", R.string.USS_Hollandia_CVE97);
        carrierMap.put("USS_Hornet_CV12", R.string.USS_Hornet_CV12);
        carrierMap.put("USS_Hornet_CV8", R.string.USS_Hornet_CV8);
        carrierMap.put("USS_Independence_CV62", R.string.USS_Independence_CV62);
        carrierMap.put("USS_Independence_CVL22", R.string.USS_Independence_CVL22);
        carrierMap.put("USS_Intrepid_CV11", R.string.USS_Intrepid_CV11);
        carrierMap.put("USS_Iwo_Jima_CV46", R.string.USS_Iwo_Jima_CV46);
        carrierMap.put("USS_Jamaica_CVE43", R.string.USS_Jamaica_CVE43);
        carrierMap.put("USS_John_C_Stennis_CVN74", R.string.USS_John_C_Stennis_CVN74);
        carrierMap.put("USS_John_F_Kennedy_CV67", R.string.USS_John_F_Kennedy_CV67);
        carrierMap.put("USS_John_F_Kennedy_CVN79", R.string.USS_John_F_Kennedy_CVN79);
        carrierMap.put("USS_Kadashan_Bay_CVE76", R.string.USS_Kadashan_Bay_CVE76);
        carrierMap.put("USS_Kalinin_Bay_CVE68", R.string.USS_Kalinin_Bay_CVE68);
        carrierMap.put("USS_Kasaan_Bay_CVE69", R.string.USS_Kasaan_Bay_CVE69);
        carrierMap.put("USS_Kearsarge_CV33", R.string.USS_Kearsarge_CV33);
        carrierMap.put("USS_Keweenaw_CVE44", R.string.USS_Keweenaw_CVE44);
        carrierMap.put("USS_Kitkun_Bay_CVE71", R.string.USS_Kitkun_Bay_CVE71);
        carrierMap.put("USS_Kitty_Hawk_CV63", R.string.USS_Kitty_Hawk_CV63);
        carrierMap.put("USS_Kula_Gulf_CVE108", R.string.USS_Kula_Gulf_CVE108);
        carrierMap.put("USS_Kwajalein_CVE98", R.string.USS_Kwajalein_CVE98);
        carrierMap.put("USS_Lake_Champlain_CV39", R.string.USS_Lake_Champlain_CV39);
        carrierMap.put("USS_Langley_CV1", R.string.USS_Langley_CV1);
        carrierMap.put("USS_Langley_CV27", R.string.USS_Langley_CV27);
        carrierMap.put("USS_Lexington_CV16", R.string.USS_Lexington_CV16);
        carrierMap.put("USS_Lexington_CV2", R.string.USS_Lexington_CV2);
        carrierMap.put("USS_Leyte_CV32", R.string.USS_Leyte_CV32);
        carrierMap.put("USS_Lingayen_CVE126", R.string.USS_Lingayen_CVE126);
        carrierMap.put("USS_Liscome_Bay_CVE56", R.string.USS_Liscome_Bay_CVE56);
        carrierMap.put("USS_Long_Island_CVE1", R.string.USS_Long_Island_CVE1);
        carrierMap.put("USS_LST16", R.string.USS_LST16);
        carrierMap.put("USS_LST525", R.string.USS_LST525);
        carrierMap.put("USS_LST906", R.string.USS_LST906);
        carrierMap.put("USS_Lunga_Point_CVE94", R.string.USS_Lunga_Point_CVE94);
        carrierMap.put("USS_Makassar_Strait_CVE91", R.string.USS_Makassar_Strait_CVE91);
        carrierMap.put("USS_Makin_Island_CVE93", R.string.USS_Makin_Island_CVE93);
        carrierMap.put("USS_Manila_Bay_CVE61", R.string.USS_Manila_Bay_CVE61);
        carrierMap.put("USS_Marcus_Island_CVE77", R.string.USS_Marcus_Island_CVE77);
        carrierMap.put("USS_Matanikau_CVE101", R.string.USS_Matanikau_CVE101);
        carrierMap.put("USS_Midway_CV41", R.string.USS_Midway_CV41);
        carrierMap.put("USS_Midway_CVE63", R.string.USS_Midway_CVE63);
        carrierMap.put("USS_Mindoro_CVE120", R.string.USS_Mindoro_CVE120);
        carrierMap.put("USS_Mission_Bay_CVE59", R.string.USS_Mission_Bay_CVE59);
        carrierMap.put("USS_Monterey_CV26", R.string.USS_Monterey_CV26);
        carrierMap.put("USS_Munda_CVE104", R.string.USS_Munda_CVE104);
        carrierMap.put("USS_Nassau_CVE16", R.string.USS_Nassau_CVE16);
        carrierMap.put("USS_Natoma_Bay_CVE62", R.string.USS_Natoma_Bay_CVE62);
        carrierMap.put("USS_Nehenta_Bay_CVE74", R.string.USS_Nehenta_Bay_CVE74);
        carrierMap.put("USS_Niantic_CVE46", R.string.USS_Niantic_CVE46);
        carrierMap.put("USS_Nimitz_CVN68", R.string.USS_Nimitz_CVN68);
        carrierMap.put("USS_Okinawa_CVE127", R.string.USS_Okinawa_CVE127);
        carrierMap.put("USS_Ommaney_Bay_CVE79", R.string.USS_Ommaney_Bay_CVE79);
        carrierMap.put("USS_Oriskany_CV34", R.string.USS_Oriskany_CV34);
        carrierMap.put("USS_Palau_CVE122", R.string.USS_Palau_CVE122);
        carrierMap.put("USS_Perdido_CVE47", R.string.USS_Perdido_CVE47);
        carrierMap.put("USS_Petrof_Bay_CVE80", R.string.USS_Petrof_Bay_CVE80);
        carrierMap.put("USS_Philippine_Sea_CV47", R.string.USS_Philippine_Sea_CV47);
        carrierMap.put("USS_Point_Cruz_CVE119", R.string.USS_Point_Cruz_CVE119);
        carrierMap.put("USS_Prince_CVE45", R.string.USS_Prince_CVE45);
        carrierMap.put("USS_Princeton_CV37", R.string.USS_Princeton_CV37);
        carrierMap.put("USS_Princeton_CVL23", R.string.USS_Princeton_CVL23);
        carrierMap.put("USS_Prince_William_CVE19", R.string.USS_Prince_William_CVE19);
        carrierMap.put("USS_Prince_William_CVE31", R.string.USS_Prince_William_CVE31);
        carrierMap.put("USS_Puget_Sound_CVE113", R.string.USS_Puget_Sound_CVE113);
        carrierMap.put("USS_Pybus_CVE34", R.string.USS_Pybus_CVE34);
        carrierMap.put("USS_Rabaul_CVE121", R.string.USS_Rabaul_CVE121);
        carrierMap.put("USS_Randolph_CV15", R.string.USS_Randolph_CV15);
        carrierMap.put("USS_Ranger_CV4", R.string.USS_Ranger_CV4);
        carrierMap.put("USS_Ranger_CV61", R.string.USS_Ranger_CV61);
        carrierMap.put("USS_Rendova_CVE114", R.string.USS_Rendova_CVE114);
        carrierMap.put("USS_Reprisal_CV35", R.string.USS_Reprisal_CV35);
        carrierMap.put("USS_Roi_CVE103", R.string.USS_Roi_CVE103);
        carrierMap.put("USS_Ronald_Reagan_CVN76", R.string.USS_Ronald_Reagan_CVN76);
        carrierMap.put("USS_Rudyerd_Bay_CVE81", R.string.USS_Rudyerd_Bay_CVE81);
        carrierMap.put("USS_Sable_IX81", R.string.USS_Sable_IX81);
        carrierMap.put("USS_Saginaw_Bay_CVE82", R.string.USS_Saginaw_Bay_CVE82);
        carrierMap.put("USS_Saidor_CVE117", R.string.USS_Saidor_CVE117);
        carrierMap.put("USS_Saipan_CVL48", R.string.USS_Saipan_CVL48);
        carrierMap.put("USS_Salamaua_CVE96", R.string.USS_Salamaua_CVE96);
        carrierMap.put("USS_Salerno_Bay_CVE110", R.string.USS_Salerno_Bay_CVE110);
        carrierMap.put("USS_Sangamon_CVE26", R.string.USS_Sangamon_CVE26);
        carrierMap.put("USS_San_Jacinto_CVL30", R.string.USS_San_Jacinto_CVL30);
        carrierMap.put("USS_Santee_CVE29", R.string.USS_Santee_CVE29);
        carrierMap.put("USS_Saratoga_CV3", R.string.USS_Saratoga_CV3);
        carrierMap.put("USS_Saratoga_CV60", R.string.USS_Saratoga_CV60);
        carrierMap.put("USS_Sargent_Bay_CVE83", R.string.USS_Sargent_Bay_CVE83);
        carrierMap.put("USS_Savo_Island_CVE78", R.string.USS_Savo_Island_CVE78);
        carrierMap.put("USS_Shamrock_Bay_CVE84", R.string.USS_Shamrock_Bay_CVE84);
        carrierMap.put("USS_ShangriLa_CV_38", R.string.USS_ShangriLa_CV_38);
        carrierMap.put("USS_Shipley_Bay_CVE85", R.string.USS_Shipley_Bay_CVE85);
        carrierMap.put("USS_Siboney_CVE112", R.string.USS_Siboney_CVE112);
        carrierMap.put("USS_Sicily_CVE118", R.string.USS_Sicily_CVE118);
        carrierMap.put("USS_Sitkoh_Bay_CVE86", R.string.USS_Sitkoh_Bay_CVE86);
        carrierMap.put("USS_Solomons_CVE67", R.string.USS_Solomons_CVE67);
        carrierMap.put("USS_St_Andrews_CVE49", R.string.USS_St_Andrews_CVE49);
        carrierMap.put("USS_Steamer_Bay_CVE87", R.string.USS_Steamer_Bay_CVE87);
        carrierMap.put("USS_St_George_CVE17", R.string.USS_St_George_CVE17);
        carrierMap.put("USS_St_Joseph_CVE50", R.string.USS_St_Joseph_CVE50);
        carrierMap.put("USS_St_Lo_CVE63", R.string.USS_St_Lo_CVE63);
        carrierMap.put("USS_St_Simon_CVE51", R.string.USS_St_Simon_CVE51);
        carrierMap.put("USS_Sunset_CVE48", R.string.USS_Sunset_CVE48);
        carrierMap.put("USS_Suwannee_CVE27", R.string.USS_Suwannee_CVE27);
        carrierMap.put("USS_Takanis_Bay_CVE89", R.string.USS_Takanis_Bay_CVE89);
        carrierMap.put("USS_Tarawa_CV40", R.string.USS_Tarawa_CV40);
        carrierMap.put("USS_Theodore_Roosevelt_CVN71", R.string.USS_Theodore_Roosevelt_CVN71);
        carrierMap.put("USS_Thetis_Bay_CVE90", R.string.USS_Thetis_Bay_CVE90);
        carrierMap.put("USS_Ticonderoga_CV14", R.string.USS_Ticonderoga_CV14);
        carrierMap.put("USS_Tinian_CVE123", R.string.USS_Tinian_CVE123);
        carrierMap.put("USS_Tripoli_CVE64", R.string.USS_Tripoli_CVE64);
        carrierMap.put("USS_Tulagi_CVE72", R.string.USS_Tulagi_CVE72);
        carrierMap.put("USS_United_States_CV58", R.string.USS_United_States_CV58);
        carrierMap.put("USS_Valley_Forge_CV45", R.string.USS_Valley_Forge_CV45);
        carrierMap.put("USS_Vella_Gulf_CVE111", R.string.USS_Vella_Gulf_CVE111);
        carrierMap.put("USS_Vermillion_CVE52", R.string.USS_Vermillion_CVE52);
        carrierMap.put("USS_Wake_Island_CVE65", R.string.USS_Wake_Island_CVE65);
        carrierMap.put("USS_Wasp_CV18", R.string.USS_Wasp_CV18);
        carrierMap.put("USS_Wasp_CV7", R.string.USS_Wasp_CV7);
        carrierMap.put("USS_White_Plains_CVE66", R.string.USS_White_Plains_CVE66);
        carrierMap.put("USS_Willapa_CVE53", R.string.USS_Willapa_CVE53);
        carrierMap.put("USS_Windham_Bay_CVE92", R.string.USS_Windham_Bay_CVE92);
        carrierMap.put("USS_Wolverine_IX64", R.string.USS_Wolverine_IX64);
        carrierMap.put("USS_Wright_CVL49", R.string.USS_Wright_CVL49);
        carrierMap.put("USS_Yorktown_CV10", R.string.USS_Yorktown_CV10);
        carrierMap.put("USS_Yorktown_CV5", R.string.USS_Yorktown_CV5);
        carrierMap.put("French_aircraft_carrier_Bearn", R.string.French_aircraft_carrier_Bearn);
        carrierMap.put("French_aircraft_carrier_Painleve", R.string.French_aircraft_carrier_Painleve);
        carrierMap.put("Japanese_aircraft_carrier_Chuyo", R.string.Japanese_aircraft_carrier_Chuyo);
        carrierMap.put("Japanese_aircraft_carrier_Hosho", R.string.Japanese_aircraft_carrier_Hosho);
        carrierMap.put("Japanese_aircraft_carrier_Hiryu", R.string.Japanese_aircraft_carrier_Hiryu);
        carrierMap.put("Japanese_aircraft_carrier_Hiyo", R.string.Japanese_aircraft_carrier_Hiyo);
        carrierMap.put("Japanese_aircraft_carrier_Junyo", R.string.Japanese_aircraft_carrier_Junyo);
        carrierMap.put("Japanese_aircraft_carrier_Ryuho", R.string.Japanese_aircraft_carrier_Ryuho);
        carrierMap.put("Japanese_aircraft_carrier_Ryujo", R.string.Japanese_aircraft_carrier_Ryujo);
        carrierMap.put("Japanese_aircraft_carrier_Soryu", R.string.Japanese_aircraft_carrier_Soryu);
        carrierMap.put("Japanese_aircraft_carrier_Shoho", R.string.Japanese_aircraft_carrier_Shoho);
        carrierMap.put("Japanese_aircraft_carrier_Shokaku", R.string.Japanese_aircraft_carrier_Shokaku);
        carrierMap.put("Japanese_aircraft_carrier_Taiho", R.string.Japanese_aircraft_carrier_Taiho);
        carrierMap.put("Japanese_aircraft_carrier_Taiyo", R.string.Japanese_aircraft_carrier_Taiyo);
        carrierMap.put("Japanese_aircraft_carrier_Unryu", R.string.Japanese_aircraft_carrier_Unryu);
        carrierMap.put("Japanese_aircraft_carrier_Zuiho", R.string.Japanese_aircraft_carrier_Zuiho);
        carrierMap.put("Japanese_battleship_Hyuga", R.string.Japanese_battleship_Hyuga);
        carrierMap.put("Spanish_aircraft_carrier_Dedalo", R.string.Spanish_aircraft_carrier_Dedalo);
        carrierMap.put("Spanish_seaplane_carrier_Dedalo", R.string.Spanish_seaplane_carrier_Dedalo);
        carrierMap.put("hello_world", R.string.hello_world);
		setContentView(R.layout.activity_aircraftcarriers);
	}
	
	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// copy 1024 bytes of file at a time
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}
	
    public void onClickSearch(View view) {
	    //Log.w(TAG, "In Aircraftcarriers.onClickSearch()");
	    //clear the existing list, possibly populated already by other searches:
	    com.jimsuplee.aircraftcarriers.Aircraftcarriers.carrierSearchList.clear();
        EditText txt_carriersearch = (EditText) findViewById(R.id.txt_carriersearch);
        String carrierdataParam = txt_carriersearch.getText().toString();
        EditText txt_carriersearchtwo = (EditText) findViewById(R.id.txt_carriersearchtwo);
        String carrierdataParamtwo = txt_carriersearchtwo.getText().toString();
        EditText txt_carriersearchthree = (EditText) findViewById(R.id.txt_carriersearchthree);
        String carrierdataParamthree = txt_carriersearchthree.getText().toString();
        carrierdataParam = "%"+carrierdataParam+"%";
        //Log.w(TAG, "In Aircraftcarriers.onClickSearch(), about to db.open()");
        db.open();
        Cursor c;
        if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()!=0) {
        	carrierdataParam ="%"+carrierdataParam+"%";
        	carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
        	carrierdataParamthree ="%"+carrierdataParamthree+"%";
        	c = db.getByCarrierdata(carrierdataParam,carrierdataParamtwo, carrierdataParamthree);
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()==0) {
        	carrierdataParam ="%"+carrierdataParam+"%";
        	carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
        	c = db.getByCarrierdata(carrierdataParam,carrierdataParamtwo);
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()==0) {
        	carrierdataParam ="%"+carrierdataParam+"%";
        	c = db.getByCarrierdata(carrierdataParam);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()!=0) {
        	carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
        	carrierdataParamthree ="%"+carrierdataParamthree+"%";
        	c = db.getByCarrierdata(carrierdataParamtwo, carrierdataParamthree);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()!=0) {
        	carrierdataParamthree ="%"+carrierdataParamthree+"%";
        	c = db.getByCarrierdata(carrierdataParamthree);
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()!=0) {
        	carrierdataParam ="%"+carrierdataParam+"%";
        	carrierdataParamthree ="%"+carrierdataParamthree+"%";
        	c = db.getByCarrierdata(carrierdataParam, carrierdataParamthree);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()==0) {
        	carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
        	c = db.getByCarrierdata(carrierdataParamtwo);
        } else {
        	//should never get here!
        	//Log.w(TAG, "In Aircraftcarriers.onClickSearch(), BAD SHOULD NEVER GET HERE");
        	carrierdataParam ="%madison%";
        	c = db.getByCarrierdata(carrierdataParam);
        }
        ////Log.w(TAG, "In Aircraftcarriers.onClickSearch(), about to db.open()");
        //db.open();
        //Log.w(TAG, "In Aircraftcarriers.onClickSearch(), about to call db.getByLyric("+carrierdataParam+")");
        //Cursor c = db.getByCarrierdata(carrierdataParam);
		//Log.w(TAG, "In Aircraftcarriers.onClickSearch(), about to db.close()");
		db.close();
		//Log.w(TAG, "In Aircraftcarriers.onClickSearch(), Got cursor from db.getByLyric("+carrierdataParam+"), now loop");
        //String results = "";
        if (c != null) {
			//Log.w(TAG, "In Aircraftcarriers.onClickSearchs(), cursor c is not null.");
		}
		//Log.w(TAG, "In Aircraftcarriers.onClickSearchs(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG, "In Aircraftcarriers.onClickSearchs(), c.moveToFirst() returned true");
			do {
				//results +=  "RESULTS: "+c.getString(0) ;
				//results += c.getString(0)+"\n";
				com.jimsuplee.aircraftcarriers.Aircraftcarriers.carrierSearchList.add(c.getString(0));
			} while (c.moveToNext());
		}else {
			//Log.w(TAG, "In Aircraftcarriers.onClickSearchs(), c.moveToFirst() returned NOT TRUE");
		}
		//Log.w(TAG, "In Aircraftcarriers.onClickSearch(), about to db.close()");
		db.close();
		//This works, WITH THE results+= line uncommented above, but it only displays unclickable results 
        //TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriername);
        //results = "These carriers match your query:\n\n"+results;
        //tv.setText(results);
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
    }
	
	public void onClickCarrier(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierArgentine(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Argentine";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierBrazilian(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Brazilian";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierFrench(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "French";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}

	public void onClickCarrierIndian(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Indian";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}

	public void onClickCarrierJapanese(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Japanese";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}

	public void onClickCarrierKoninklijke(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Koninklijke";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}

	public void onClickCarrierKriegsmarine(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Kriegsmarine";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierMarinaMilitare(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "MarinaMilitare";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierPLA(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "PLA";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierThai(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Thai";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierRussian(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Russian";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierSpanish(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Spanish";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}	
	public void onClickCarrierSwedish(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "Swedish";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickCarrierUk(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "UK";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}	
	public void onClickCarrierUs(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickCarrier()");
		navy = "US";
		//Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		Intent iCarrier = new Intent("com.jimsuplee.aircraftcarriers.Carrier");
		startActivityForResult(iCarrier, 0);
	}
	public void onClickNavy(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickNavy()");
		ImageView iv = (ImageView) findViewById(R.id.us);
		//iv.setImageResource(R.drawable.us);
		//iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.argentine);
		iv.setImageResource(R.drawable.argentine);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.brazilian);
		iv.setImageResource(R.drawable.brazilian);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.french);
		iv.setImageResource(R.drawable.french);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.indian);
		iv.setImageResource(R.drawable.indian);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.japanese);
		iv.setImageResource(R.drawable.japanese);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.koninklijke);
		iv.setImageResource(R.drawable.koninklijke);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.kriegsmarine);
		iv.setImageResource(R.drawable.kriegsmarine);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.marinamilitare);
		iv.setImageResource(R.drawable.marinamilitare);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.pla);
		iv.setImageResource(R.drawable.pla);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.russian);
		iv.setImageResource(R.drawable.russian);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.spanish);
		iv.setImageResource(R.drawable.spanish);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.swedish);
		iv.setImageResource(R.drawable.swedish);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.thai);
		iv.setImageResource(R.drawable.thai);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.uk);
		iv.setImageResource(R.drawable.uk);
		iv.setVisibility(View.VISIBLE);
		iv = (ImageView) findViewById(R.id.us);
		iv.setImageResource(R.drawable.us);
		iv.setVisibility(View.VISIBLE);
		
		Button btn = (Button) findViewById(R.id.btn_argentine);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_Brazilian);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_french);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_indian);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_japanese);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_koninklijke);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_kriegsmarine);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_marinamilitare);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_pla);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_russian);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_spanish);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_swedish);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_thai);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_uk);
		btn.setVisibility(View.VISIBLE);
		btn = (Button) findViewById(R.id.btn_us);
		btn.setVisibility(View.VISIBLE);
	
	}
	public void onClickSummary(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summary);
	}
	public void onClickSummaryService(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summarybyservice);
	}	
	public void onClickSummaryServiceperiod(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summarybyserviceperiod);
	}
	public void onClickSummaryClass(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summarybyclass);
	}
	public void onClickSummaryType(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summarybytype);
	}
	public void onClickSummaryPennant(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickSummary()");
		navy = "";
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.summarybypennant);
	}
	
	public void onClickInfo(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickInfo()");
		navy = "";		
		TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriername);
		tv.setVisibility(View.VISIBLE);
		tv.setText(R.string.app_name);
		TextView tvtwo = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
		tvtwo.setVisibility(View.VISIBLE);
		tvtwo.setText(R.string.info);
	}
	public void onClickPictures(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickPictures()");
		navy = "";
		startActivity(new Intent("com.jimsuplee.aircraftcarriers.Pictures"));
	}
	public void onClickPicturesus(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickPicturesus()");
		navy = "";
		startActivity(new Intent("com.jimsuplee.aircraftcarriers.Picturesus"));
	}
	public void onClickBig(View view) {
		//Log.w(TAG, "In Aircraftcarriers.onClickBig()");
		navy = "";
		startActivity(new Intent("com.jimsuplee.aircraftcarriers.Big"));
	}
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ---check if the request code is 0 1 2 3 4 5---
		////Log.w(TAG, "In Aircraftcarriers.onActivityResult(), checking reqCod");
		// onClickLocation startActivityForResult section
		if (requestCode == 0) {
			////Log.w(TAG, "In Aircraftcarriers.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				String carrier = data.getData().toString();
				TextView tvname = (TextView) findViewById(R.id.txt_Aircraftcarriername);
				tvname.setText(carrier);
				TextView tv = (TextView) findViewById(R.id.txt_Aircraftcarriersdata);
				tv.setVisibility(View.VISIBLE);
				Integer carrierTextId = carrierMap.get(carrier);
				if(carrierTextId != null) {
					//tv.setText(carrierMap.get(carrier));
					tv.setText(carrierTextId);
				}else {
				    tv.setText(R.string.hello_world);	
				}
				ImageView iv = (ImageView) findViewById(R.id.imagedetail);
				Integer photoId = photoMap.get(carrier);
				if(photoId != null) {
    				iv.setImageResource(photoMap.get(carrier));
				} else {
					iv.setImageResource(R.drawable.carrier);
				}
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aircraftcarriers, menu);
		return true;
	}

}
