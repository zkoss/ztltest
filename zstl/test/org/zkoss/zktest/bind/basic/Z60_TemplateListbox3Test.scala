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
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TemplateListbox3Test extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = {
      <include src="bind/basic/collection-template-listbox.zul"/>
    }
    runZTL(zul, () => {
      		var outerbox = jq("$outerbox").toWidget()
		var outeritems = outerbox.firstChild() // include header
		var itemLabel = Array( "A", "B", "C", "D" )
		verifyEquals(itemLabel.length, outerbox.nChildren() - 1)
		var outeritem = outeritems
		for(i <- 0 to itemLabel.length - 1)
		{
			outeritem = outeritem.nextSibling()
			var outerl = itemLabel(i)
			var cell = outeritem.firstChild()
			verifyEquals("" + i, cell.get("label"))// verify the index
			cell = cell.nextSibling()
			verifyEquals(outerl, cell.get("label"))// verify the label
			// verify template
			cell = outeritem.lastChild()
			if(outerl.equals("A") || i == 2)
				verifyEquals("Model1", cell.get("label"))
			else
				verifyEquals("Model2", cell.get("label"))
		}
		// ==============================================
		var buttons = jq("@button")
		
		for(i <- 0 to buttons.length() -1)
		{
			var btn = buttons.eq(i).toWidget()
			if("change1".equals(btn.get("label")))
			{
				click(btn)
				waitResponse()
			}
		}
		outerbox = jq("$outerbox").toWidget()
		outeritems = outerbox.firstChild() // include header
		itemLabel = Array( "X", "A", "C", "D" )
		verifyEquals(itemLabel.length, outerbox.nChildren() - 1)
		outeritem = outeritems
		for(i <- 0 to itemLabel.length - 1)
		{
			outeritem = outeritem.nextSibling()
			var outerl = itemLabel(i)
			var cell = outeritem.firstChild()
			verifyEquals("" + i, cell.get("label"))// verify the index
			cell = cell.nextSibling()
			verifyEquals(outerl, cell.get("label"))// verify the label
			// verify template
			cell = outeritem.lastChild()
			if(outerl.equals("A") || i == 2)
				verifyEquals("Model1", cell.get("label"))
			else
				verifyEquals("Model2", cell.get("label"))
		}
		// ==============================================
		buttons = jq("@button")
		for(i <- 0 to buttons.length() -1)
		{
			var btn = buttons.eq(i).toWidget()
			if("change2".equals(btn.get("label")))
			{
				click(btn)
				waitResponse()
			}
		}
		outerbox = jq("$outerbox").toWidget()
		outeritems = outerbox.firstChild() // include header
		itemLabel = Array( "A", "B", "C", "D")
		verifyEquals(itemLabel.length, outerbox.nChildren() - 1)
		outeritem = outeritems
		for(i <- 0 to itemLabel.length - 1)
		{
			outeritem = outeritem.nextSibling()
			var outerl = itemLabel(i)
			var cell = outeritem.firstChild()
			verifyEquals("" + i, cell.get("label"))// verify the index
			cell = cell.nextSibling()
			verifyEquals(outerl, cell.get("label"))// verify the label
			// verify template
			cell = outeritem.lastChild()
			if(outerl.equals("A") || i == 2)
				verifyEquals("Model1", cell.get("label"))
			else
				verifyEquals("Model2", cell.get("label"))
		}
    })
  }
}