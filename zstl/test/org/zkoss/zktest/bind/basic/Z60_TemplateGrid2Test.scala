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
package org.zkoss.zktest.bind.basic
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TemplateGrid2Test extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="bind/databinding/collection/collection-template-grid.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid").toWidget();
      var outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      // =================================delete 2rd row
      var outeritem = outerrows.nextSibling(); // 1
      click(jq(outeritem).find("@button").eq(1)); // click the delete button on 2nd row
      waitResponse();
      outerbox = jq("$outergrid").toWidget();
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      var itemLabel = Array("A", "C", "D");
      verifyEquals(3, jq(outerbox).find("@rows").toWidget().nChildren());
      var outerrow = outerrows;
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
        // verify inner index
        var innergrid = rowkid.nextSibling();
        verifyTrue(innergrid.exists());
        var innerrows = jq(innergrid).find("@row");
        verifyEquals(2, innerrows.length());
        for (j <- 0 to 1) {
          var innerrow = innerrows.eq(j).toWidget();
          rowkid = innerrow.firstChild();
          verifyEquals("" + j, rowkid.attr("value"));
          rowkid = rowkid.nextSibling();
          verifyEquals("" + i, rowkid.attr("value"));
          var innerl = itemLabel(i) + " " + j;
          rowkid = rowkid.nextSibling();
          verifyEquals(innerl, rowkid.attr("value"));
        }
        rowkid = outerrow.lastChild().previousSibling();
        var btn = jq(rowkid).find("@button").toWidget(); // index button
        var msg = jq("$msg").toWidget();
        click(btn);
        waitResponse();
        verifyEquals("item index " + i, msg.attr("value"));
        // verify template
        rowkid = outerrow.lastChild();
        var label = jq(rowkid).find("@label").toWidget(); // index button
        if (outerl.equals("A") || i == 2) {
          verifyEquals("Model1", label.attr("value"));
        } else {
          verifyEquals("Model2", label.attr("value"));
        }
        outerrow = outerrow.nextSibling();
      }
      // =================================add after row
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      outeritem = outerrows.nextSibling(); // 1
      click(jq(outeritem).find("@button").eq(2).toWidget()); // add after 2nd row
      waitResponse();
      outerbox = jq("$outergrid").toWidget();
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      itemLabel = Array("A", "C", "C1", "D");
      verifyEquals(4, jq(outerbox).find("@rows").toWidget().nChildren());
      outerrow = outerrows;
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
        rowkid = outerrow.lastChild();
        var label = jq(rowkid).find("@label").toWidget(); // index button
        if (outerl.equals("A") || i == 2) {
          verifyEquals("Model1", label.attr("value"));
        } else {
          verifyEquals("Model2", label.attr("value"));
        }
        outerrow = outerrow.nextSibling();
      }
      // =================================add after row
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      outeritem = outerrows.nextSibling().nextSibling(); // 2
      click(jq(outeritem).find("@button").eq(3).toWidget()); // add after 2nd row
      waitResponse();
      outerbox = jq("$outergrid").toWidget();
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      itemLabel = Array("A", "C", "C12", "C1", "D");
      verifyEquals(5, jq(outerbox).find("@rows").toWidget().nChildren());
      outerrow = outerrows;
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
        rowkid = outerrow.lastChild();
        var label = jq(rowkid).find("@label").toWidget(); // index button
        if (outerl.equals("A") || i == 2) {
          verifyEquals("Model1", label.attr("value"));
        } else {
          verifyEquals("Model2", label.attr("value"));
        }
        outerrow = outerrow.nextSibling();
      }
    })
  }
}