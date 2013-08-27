/* Z60_Listbox_ListModelMap_RODTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Jan 17 14:31:02 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

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

/**
 * A test class for bug Listbox-ListModelMap-ROD
 * @author benbai
 *
 */
@Tags(tags = "Z60-Listbox-ListModelMap-ROD.zul,Z60,A,E,Listbox,ListModelMap,ROD")
class Z60_Listbox_ListModelMap_RODTest extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zul = {
      <include src="/test2/Z60-Listbox-ListModelMap-ROD.zul"/>
    }
    runZTL(zul,
        () => {
        var outer: Widget = engine.$f("outer");
        var lbxOne: Widget = engine.$f("lbxOne");
        var lbxTwo: Widget = engine.$f("lbxTwo");
        var lbxThree: Widget = engine.$f("lbxThree");
        var tbOne: Widget = engine.$f("tbOne");
        var tbTwo: Widget = engine.$f("tbTwo");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");
        var btnSix: Widget = engine.$f("btnSix");
        var btnSeven: Widget = engine.$f("btnSeven");
        var msg: Widget = engine.$f("msg");
        var itemHgh: Int = jq(lbxOne.$n()).find(".z-listitem").outerHeight(true);
        var checkList: java.util.List[Int] = new java.util.ArrayList[Int]();

        def selectItem = (id: String, num: Int) => {
          var lbx: Widget = engine.$f(id);
         
          verScroll(lbx, if(num > 2) (num - 3) / 300.0 else 0.0)
	      waitResponse();
          
          if (!isOpera()) // wait ROD if any
        	  sleep(1000);
          var listitem: Element = jq(lbx.$n("body")).find(".z-listitem:contains(\"data "+num+"\")").get(0);
          if (isOpera()) // opera rod will do after get listitem
        	  sleep(1000);

          clickAt(listitem, "5,5");
        }
        // check whether the selection of a listbox contains exactly the content in check list
        def checkSelection = (toCheck: java.util.List[Int], id: String) => {
          input(tbOne.$n(), id);
          click(btnFour);
          waitResponse();
          var selection: String = getText(msg)
          var item: String = "";
          for (i <- 0 to toCheck.size()-1) {
            item = "item "+toCheck.get(i)+"=data "+toCheck.get(i);
            verifyTrue("the selection of "+id+"should contains "+item,
                selection.contains(item));
            selection = selection.replace(item, "");
          }
          verifyTrue("the selection should exactly contains the check list data, no more",
              selection.length() == 0);
        }
        def checkEqualSelection = (idOne: String, idTwo: String, assertValue: Boolean) => {
          input(tbOne.$n(), idOne);
          input(tbTwo.$n(), idTwo);
          click(btnOne);
          waitResponse();
          if (assertValue)
            verifyTrue("The selection of these two listbox ("+idOne+", "+idTwo+") should the same",
                getText(msg).equals("true"));
          else
            verifyTrue("The selection of these two listbox ("+idOne+", "+idTwo+") should different",
                getText(msg).equals("false"));
        }
        def input = (tb: Element, value: String) => {
          click(tb);
          tb.eval("value = \"" + value+"\"");
          click(outer);
          waitResponse();
        }
        def checkInsertRemove = () => {
          var selsOne: String = getSelection("lbxOne");
          var selsTwo: String = getSelection("lbxTwo");
          var selsThree: String = getSelection("lbxThree");
          click(btnSix); waitResponse();
          click(btnSix); waitResponse();
          click(btnSix); waitResponse();
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxOne").equals(selsOne));
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxTwo").equals(selsTwo));
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxThree").equals(selsThree));
          click(btnSeven); waitResponse();
          click(btnSeven); waitResponse();
          click(btnSeven); waitResponse();
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxOne").equals(selsOne));
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxTwo").equals(selsTwo));
          verifyTrue("The selection should not change after insert items",
              getSelection("lbxThree").equals(selsThree));
        }
        def getSelection (id: String): String = {
          input(tbOne.$n(), id)
          click(btnFour)
          waitResponse()
          return getText(msg)
        }
        selectItem("lbxOne", 2);
        checkEqualSelection("lbxOne", "lbxTwo", true);
        selectItem("lbxTwo", 200);
        checkEqualSelection("lbxOne", "lbxTwo", true);

        selectItem("lbxThree", 10);
        click(btnTwo);
        sleep(1000);
        click(btnThree);
        sleep(1000);

        checkList.add(10);
        checkSelection(checkList, "lbxThree");

        checkEqualSelection("lbxThree", "lbxThree_clone0", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", true);
        selectItem("lbxThree", 212);
        selectItem("lbxThree_clone0", 213);
        selectItem("lbxThree_serialize1", 214);

        checkEqualSelection("lbxThree", "lbxThree_clone0", false);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", false);
        checkEqualSelection("lbxThree_clone0", "lbxThree_serialize1", false);

        click(btnTwo);
        sleep(1000);
        click(btnThree);
        sleep(1000);

        checkList.clear();
        checkList.add(212);
        checkSelection(checkList, "lbxThree");

        checkEqualSelection("lbxThree", "lbxThree_clone2", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize3", true);
        checkInsertRemove();
    }
   );
  }
}