/* B30_1752477Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1752477Test extends ZTL4ScalaTestCase {
  @Test
  def testLayout() = {
    var zscript =
      """
			<window title="checkbox demo" border="normal">
			See if the position of combobox image is right.
				<groupbox mold="3d" height="100%" width="100%">
					<caption label="test something" />
					Combobox:
					<vbox>
						<combobox id="cb1">
							<comboitem label="Simple and Rich"/>
							<comboitem label="Cool!"/>
							<comboitem label="Thumbs Up!"/>
						</combobox>
						<combobox id="cb2">
							<comboitem label="Simple and Rich"
							description="The simplest way to make Web applications rich"/>
							<comboitem label="Cool!"
							description="The coolest technology"/>
							<comboitem label="Ajax and RIA"
							description="Rich Internet Application by Ajax"/>
						</combobox>
						<combobox  id="cb3">
							<comboitem label="Simple and Rich" image="/test2/img/coffee.gif"
							description="The simplest way to make Web applications rich"/>
							<comboitem label="Cool!" image="/test2/img/corner.gif"
							description="The coolest technology"/>
							<comboitem label="Ajax and RIA" image="/test2/img/cubfirs.gif"
							description="Rich Internet Application by Ajax"/>
						</combobox>
			
						<separator bar="true"/>
						Auto-complete:
						<combobox autodrop="true"  id="cb4"/>
						<zscript>
				String[] _dict = { 
					"abacus", "accuracy", "acuity", "adage", "afar", "after", "apple",
					"bible", "bird", "bingle", "blog",
					"cabane", "cape", "cease", "cedar",
					"dacron", "defacto", "definable", "deluxe",
					"each", "eager", "effect", "efficacy",
					"far", "far from",
					"girl", "gigantean", "giant",
					"home", "honest", "huge",
					"information", "inner",
					"jump", "jungle", "jungle fever",
					"kaka", "kale", "kame",
					"lamella", "lane", "lemma",
					"master", "maxima", "music",
					"nerve", "new", "number",
					"omega", "opera",
					"pea", "peace", "peaceful",
					"rock", "RIA",
					"sound", "spread", "student", "super",
					"tea", "teacher",
					"unit", "universe",
					"vector", "victory",
					"wake", "wee", "weak", "web2.0",
					"xeme",
					"yea", "yellow",
					"zebra", "zk",
					
				};
				 ListModel dictModel= new SimpleListModel(_dict);
				 cb4.setModel(dictModel);
				</zscript>
						<hbox>
							<checkbox checked="true" onCheck="combo.autodrop = self.checked"
							label="auto drop popup when typing"/>
							<checkbox checked="true" onCheck="combo.buttonVisible = self.checked"
							label="button visible"/>
						</hbox>
					</vbox>
				</groupbox>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    val cb2 = ztl$engine.$f("cb2")
    val cb3 = ztl$engine.$f("cb3")
    val cb4 = ztl$engine.$f("cb4")
    runZTL(zscript, () => {
      verifyEquals(jq(cb1.$n()).outerWidth(), jq(cb2.$n()).outerWidth())
      verifyEquals(jq(cb2.$n()).outerWidth(), jq(cb3.$n()).outerWidth())
      verifyEquals(jq(cb3.$n()).outerWidth(), jq(cb4.$n()).outerWidth())
      verifyEquals(jq(cb1.$n("btn")).outerWidth(), jq(cb2.$n("btn")).outerWidth())
      verifyEquals(jq(cb2.$n("btn")).outerWidth(), jq(cb3.$n("btn")).outerWidth())
      verifyEquals(jq(cb3.$n("btn")).outerWidth(), jq(cb4.$n("btn")).outerWidth())
      verifyEquals(jq(cb1).find("i").outerWidth(), jq(cb2).find("i").outerWidth())
      verifyEquals(jq(cb2).find("i").outerWidth(), jq(cb3).find("i").outerWidth())
      verifyEquals(jq(cb3).find("i").outerWidth(), jq(cb4).find("i").outerWidth())
      verifyEquals(jq(cb1.$n()).outerHeight(), jq(cb2.$n()).outerHeight())
      verifyEquals(jq(cb2.$n()).outerHeight(), jq(cb3.$n()).outerHeight())
      verifyEquals(jq(cb3.$n()).outerHeight(), jq(cb4.$n()).outerHeight())
      verifyEquals(jq(cb1.$n("btn")).outerHeight(), jq(cb2.$n("btn")).outerHeight())
      verifyEquals(jq(cb2.$n("btn")).outerHeight(), jq(cb3.$n("btn")).outerHeight())
      verifyEquals(jq(cb3.$n("btn")).outerHeight(), jq(cb4.$n("btn")).outerHeight())
      verifyEquals(jq(cb1).find("i").outerHeight(), jq(cb2).find("i").outerHeight())
      verifyEquals(jq(cb2).find("i").outerHeight(), jq(cb3).find("i").outerHeight())
      verifyEquals(jq(cb3).find("i").outerHeight(), jq(cb4).find("i").outerHeight());
    })
  }
}



