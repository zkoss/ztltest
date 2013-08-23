package org.zkoss.zstl

import org.zkoss.ztl.ClientWidget
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element

/**
 * ZTL for MeshWidget to test
 * @author Ramond Chao
 */
class ZTL4MeshTestCase extends ZTL4ScalaTestCase {
    
    def selectListitem = (listbox: ClientWidget, num: Int) => {
      
      if(num > 4) 
        verScrollMesh(listbox, (num + 1) / 300.0)
      var listitem: Element = jq(jq(listbox).toWidget().$n("body")).
      							find(".z-listitem:contains(\"data " + num + "\")").get(0)
      click(listitem, false)
    }
    
    def getSelection (id: String): String = {
      input(engine.$n("tbOne"), id)
      click(engine.$f("btnFour"), false)
      return getText(engine.$f("msg"))
    }
    
    // check whether the selection of a meshwidget contains exactly the content in check list
    def checkSelection = (toCheck: java.util.List[Int], id: String) => {
      var selection: String = getSelection(id)
      var item: String = ""
      for (i <- 0 until toCheck.size()) {
        item = "data " + toCheck.get(i)
        verifyTrue("the selection of " + id + "should contains " + item,
            selection.contains(item))
        selection = selection.replace(item, "")
      }
      verifyTrue("the selection should exactly contains the check list data, no more",
          selection.length() == 0)
    }
    def checkEqualSelection = (idOne: String, idTwo: String, assertValue: Boolean) => {
      input(engine.$f("tbOne"), idOne)
      input(engine.$f("tbTwo"), idTwo)
      click(engine.$f("btnOne"), false)
      if (assertValue)
        verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should the same",
            "true".equals(getText(engine.$n("msg"))))
      else
        verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should different",
           "false".equals(getText(engine.$n("msg"))))
    }
    
    def input = (tb: ClientWidget, value: String) => {
      click(tb, false)
      tb.toElement().eval("value = \"" + value + "\"")
    }
 
    def checkInsertRemove = () => {
      var selsOne: String = getSelection("lbxOne")
      var selsTwo: String = getSelection("lbxTwo")
      var selsThree: String = getSelection("lbxThree")
      var btnSix: Element = engine.$n("btnSix")
      var btnSeven: Element = engine.$n("btnSeven")
      for (i <- 1 to 3)
    	  click(btnSix, false)
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxOne").equals(selsOne))
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxTwo").equals(selsTwo))
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxThree").equals(selsThree))
      for (i <- 1 to 3)
    	  click(btnSeven, false)
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxOne").equals(selsOne))
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxTwo").equals(selsTwo))
      verifyTrue("The selection should not change after insert items",
          getSelection("lbxThree").equals(selsThree))
    }
    
}