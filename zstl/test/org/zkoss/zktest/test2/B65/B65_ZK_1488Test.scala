package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1488.zul")
class B65_ZK_1488Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
                  <zk>
                    <label multiline="true">
                      <![CDATA[
		1. Please right-click upon the list item.
		2. You should be able to see the menu popup appeared.
		3. Plaase left-click upon the list item again.
		4. You should be able to see the menu popup  appeared.
	]]>
                    </label>
                    <zscript>
                      import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;
public class TestComposer extends GenericForwardComposer{

                        public void doAfterCompose(Component comp) throws Exception {
                          super.doAfterCompose(comp);

                          TestListbox listbox = new TestListbox();
                          listbox.setVflex("1");
                          listbox.setHflex("1");

                          listbox.appendChild(new Listitem("A"));
                          listbox.appendChild(new Listitem("B"));

                          listbox.setParent(comp);
                        }

                      }
                      public class TestListbox extends Listbox{

                        Menupopup popup;
                        Menupopup context;

                        public TestListbox () {
                          popup = new Menupopup();
                          popup.appendChild(new Menuitem("menu A"));
                          popup.appendChild(new Menuitem("menu B"));
                          context = new Menupopup();
                          context.appendChild(new Menuitem("context menu A"));
                          context.appendChild(new Menuitem("context menu B"));

                          setContext(context);
                          setPopup(popup);
                        }
                        public void onPageAttached(Page newpage, Page oldpage) {
                          super.onPageAttached(newpage, oldpage);
                          popup.setPage(newpage);
                          context.setPage(newpage);
                        }

                      }
                    </zscript>
                    <window border="normal" title="hello" apply="TestComposer"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        contextMenu(jq(".z-listitem:eq(0)"))
        waitResponse()
        verifyNotEquals(jq(".z-menupopup:contains(context menu A)").css("display"), "none")
        
        click(jq(".z-listitem:eq(1)"))
        waitResponse()
        verifyEquals(jq(".z-menupopup:contains(context menu A)").css("display"), "none")
        verifyNotEquals(jq(".z-menupopup:contains(menu A):eq(1)").css("display"), "none")
      })

  }
}
