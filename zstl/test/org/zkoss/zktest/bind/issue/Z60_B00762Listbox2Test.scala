/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00762Listbox2Test extends ZTL4ScalaTestCase {

  def getListboxSelectedIndex(listbox: Widget): Int = {
    var index = -1
    var listitems = listbox.firstChild() // include header
    for (i <- 0 to listbox.nChildren() - 2) {
      listitems = listitems.nextSibling();
      if (listitems.is("selected"))
        index = i
    }
    index
  }
  
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00762Listbox2.zul"/>
    }

    runZTL(zul, () => {
    	var outerbox = jq("$outerbox");
		var min = jq("$min").toWidget();
		// var max = findWidget("$max");
		var clean = jq("$clean").toWidget();
		var select = jq("$select").toWidget();
		var showselect = jq("$showselect").toWidget();
		click(outerbox.find("@listitem").eq(0).toWidget());
		waitResponse();
		click(showselect);
		waitResponse();
		verifyEquals("0", min.get("value"));
		// verifyEquals("0", max.get("value"));
		click(outerbox.find("@listitem").eq(2).toWidget());
		waitResponse();
		click(showselect);
		waitResponse();
		verifyEquals("2", min.get("value"));
		// verifyEquals("2", max.get("value"));
		click(clean);
		waitResponse();
		verifyEquals("-1", getListboxSelectedIndex(outerbox.toWidget()));
		click(showselect);
		waitResponse();
		verifyEquals("-1", min.get("value"));
		// verifyEquals("-1", max.get("value"));
		click(select);
		waitResponse();
		verifyEquals("1", getListboxSelectedIndex(outerbox.toWidget()));
		click(showselect);
		waitResponse();
		verifyEquals("1", min.get("value"));
		// verifyEquals("1", max.get("value"));
    })
    
  }
}

