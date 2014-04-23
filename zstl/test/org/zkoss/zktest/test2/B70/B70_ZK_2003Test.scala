package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2003.zul")
class B70_ZK_2003Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="Splitter Borderlayout Popup" contentType="text/html;charset=UTF-8"?>
<zk>
	<label multiline="true">
		1.Click the button of combobox, then the comboboxpopoup will show up.
		2.Drag splitter of borderlayout,and the comboboxpopoup must be hidden.
		3.Click the button of bandbox, then the bandpopup will show up.
		4.Drag splitter of borderlayout,and the bandpopup must be hidden.
	</label>
	<borderlayout height="300px" width="500px">
		<north splittable="true" collapsible="true" height="45%">
			<combobox>
			    <comboitem label="Simple and Rich"/>
			    <comboitem label="Cool!"/>
			    <comboitem label="Ajax and RIA"/>
			</combobox>
		</north>
		<center>
			<bandbox id="bd">
				<bandpopup>
			        <vbox>
			            <hbox>
			                Search
			                <textbox />
			            </hbox>
			            <listbox width="200px"
			                onSelect="bd.value=self.selectedItem.label;bd.close();">
			                <listhead>
			                    <listheader label="Name" />
			                    <listheader label="Description" />
			                </listhead>
			                <listitem>
			                    <listcell label="John" />
			                    <listcell label="CEO" />
			                </listitem>
			                <listitem>
			                    <listcell label="Joe" />
			                    <listcell label="Engineer" />
			                </listitem>
			                <listitem>
			                    <listcell label="Mary" />
			                    <listcell label="Supervisor" />
			                </listitem>
			            </listbox>
			        </vbox>
			    </bandpopup>
			</bandbox>
		</center>
	</borderlayout>
</zk>"""
    runZTL(zscript,
      () => {

        val split = jq(".z-north").toWidget().$n("split")
        List("combobox", "bandbox") foreach { comp =>
          val wgt = jq(".z-" + comp).toWidget()
          val wgtpp = wgt.$n("pp")
          click(wgt.$n("btn"))
          waitResponse()
          verifyTrue("the " + comp + " popup will show up", jq(wgtpp).isVisible())

          val p = "2,2"
          val np = "2,4"

          mouseMoveAt(split, p)
          waitResponse

          mouseDownAt(split, p)
          waitResponse

          mouseMoveAt(split, np)
          waitResponse

          mouseUpAt(split, np)
          waitResponse

          verifyTrue("the " + comp + " popup must be hidden", !jq(wgtpp).isVisible())
        }
      })

  }
}