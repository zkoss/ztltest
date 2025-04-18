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
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TemplateGrid3Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="bind/databinding/collection/collection-template-grid.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid").toWidget();
      var outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      var itemLabel = Array("A", "B", "C", "D");
      verifyEquals(4, jq(outerbox).find("@rows").toWidget().nChildren());
      var outerrow = outerrows;

      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
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
      // ===========================================
      click(jq(".z-button:contains(change1)"))
      waitResponse();
      outerbox = jq("$outergrid").toWidget();
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      itemLabel = Array("X", "A", "C", "D");
      verifyEquals(4, jq(outerbox).find("@rows").toWidget().nChildren());
      outerrow = outerrows;
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
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
      // ===========================================
      click(jq(".z-button:contains(change2)"))
      waitResponse();
      outerbox = jq("$outergrid").toWidget();
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild();
      itemLabel = Array("A", "B", "C", "D");
      verifyEquals(4, jq(outerbox).find("@rows").toWidget().nChildren());
      outerrow = outerrows;
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i);
        var rowkid = outerrow.firstChild();
        verifyEquals("" + i, rowkid.attr("value")); // verify the index on label
        rowkid = rowkid.nextSibling();
        verifyEquals(outerl, rowkid.attr("value")); // verify the label on label
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
    })
  }
}