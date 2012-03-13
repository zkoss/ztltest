/* F50_3287044Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 16:50:14 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A test class for bug 3287044
 * @author benbai
 *
 */
@Tags(tags = "F50-3287044.zul,A,E,Decimalbox,Doublebox,Intbox,Longbox,Spinner,Doublespinner,Locale")
class F50_3287044Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				1. Please check each input value is the same as the "Correct Result"
				<separator/>
				2. Please click the button "Change all locales to Taiwan", and then you should see
				all of the input values will be the same as the correct result in TW (Taiwan).
				<grid width="600px" span="3">
					<columns>
						<column hflex="min" label="Locale(Correct Result)" />
						<column hflex="min" label="Doublebox" />
						<column hflex="min" label="Decimalbox" />
						<column hflex="min" label="Doublespinner" />
					</columns>
					<rows id="rows">
						<row>
							zh_TW (Taiwan): 2,000.02
							<doublebox id="box1" format="#,###.00" locale="zh_TW"
								value="2000.02" />
							<decimalbox id="box2" format="#,###.00" locale="zh_TW" value="2000.02"/>
							<doublespinner id="box3" format="#,###.00" locale="zh_TW" value="2000.02" step="0.5"/>
						</row>
						<row>
							FR (French): 2 000,02
							<doublebox id="box4" format="#,###.00" locale="fr"
								value="2000.02" />
							<decimalbox id="box5" format="#,###.00" locale="fr" value="2000.02"/>
							<doublespinner id="box6" format="#,###.00" locale="fr" value="2000.02" step="0.5"/>
						</row>
						<row>
							<label pre="true">IT (Italian):    2.000,02</label>
							<doublebox id="box7" format="#,###.00" locale="it"
								value="2000.02" />
							<decimalbox id="box8" format="#,###.00" locale="it" value="2000.02"/>
							<doublespinner id="box9" format="#,###.00" locale="it" value="2000.02" step="0.5"/>
						</row>
					</rows>
				</grid>
				<button id="btn" label="Change all locales to Taiwan">
					<attribute name="onClick"><![CDATA[
						for(Iterator it = rows.getChildren().iterator(); it.hasNext();) {
							for(Iterator itt = it.next().getChildren().iterator(); itt.hasNext();) {
									Component c = itt.next();
									if (c instanceof org.zkoss.zul.impl.NumberInputElement)
										c.setLocale("zh_TW");
							}
						}
						]]></attribute>
				</button>
			</zk>
    }

   runZTL(zscript, () => {
   			var (box1: Widget,
   				box2: Widget,
   				box3: Widget,
   				box4: Widget,
   				box5: Widget,
   				box6: Widget,
   				box7: Widget,
   				box8: Widget,
   				box9: Widget,
   				btn: Widget) = (
   						engine.$f("box1"),
   						engine.$f("box2"),
   						engine.$f("box3"),
   						engine.$f("box4"),
   						engine.$f("box5"),
   						engine.$f("box6"),
   						engine.$f("box7"),
   						engine.$f("box8"),
   						engine.$f("box9"),
   						engine.$f("btn")
    	    );
   			def verify(node: Element, locale: String) {
   			  
   				verifyEquals(node.get("value"), NumberFormat.getNumberInstance(new Locale(locale)).format(2000.02));
   			}
   			verify(box1.$n(), "zh_TW");
   			verify(box2.$n(), "zh_TW");
   			verify(jq(box3.$n()).find("input").get(0), "zh_TW");
   			verify(box4.$n(), "fr");
   			verify(box5.$n(), "fr");
   			verify(jq(box6.$n()).find("input").get(0), "fr");
   			verify(box7.$n(), "it");
   			verify(box8.$n(), "it");
   			verify(jq(box9.$n()).find("input").get(0), "it");
   			click(btn);
   			waitResponse();
   			verify(box1.$n(), "zh_TW");
   			verify(box2.$n(), "zh_TW");
   			verify(jq(box3.$n()).find("input").get(0), "zh_TW");
   			verify(box4.$n(), "zh_TW");
   			verify(box5.$n(), "zh_TW");
   			verify(jq(box6.$n()).find("input").get(0), "zh_TW");
   			verify(box7.$n(), "zh_TW");
   			verify(box8.$n(), "zh_TW");
   			verify(jq(box9.$n()).find("input").get(0), "zh_TW");
		})
  }

}