package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2775.zul")
class B70_ZK_2776Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """
<?xml version="1.0" encoding="UTF-8"?>
<zk>
    <zscript><![CDATA[

    import org.zkoss.bind.annotation.Init;
    import org.zkoss.zul.ListModelList;
    public class Customer
    {
        private String name0;
        private String name1;
        private String name2;
        private String name3;
        private String name4;
        private String name5;
        public Customer() {}
        public Customer(String name0, String name1, String name2, String name3, String name4, String name5) {
            this.name0 = name0;
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
            this.name4 = name4;
            this.name5 = name5;
        }
        public String getName0() {
            return name0;
        }
        public void setName0(String name0)
        {
            this.name0 = name0;
        }
        public String getName1()
        {
            return name1;
        }
        public void setName1(String name1)
        {
            this.name1 = name1;
        }
        public String getName2()
        {
            return name2;
        }
        public void setName2(String name2)
        {
            this.name2 = name2;
        }
        public String getName3()
        {
            return name3;
        }
        public void setName3(String name3)
        {
            this.name3 = name3;
        }
        public String getName4()
        {
            return name4;
        }
        public void setName4(String name4)
        {
            this.name4 = name4;
        }
        public String getName5()
        {
            return name5;
        }
        public void setName5(String name5)
        {
            this.name5 = name5;
        }
    }

    public class TestVM
    {
        private ListModelList customers;
        public TestVM() {
            this.customers = new ListModelList();
            for(int i = 0; i < 20; i++)
                this.customers.add(new Customer("Name " + i, "Name " + i, "Name " + i, "Name " + i, "looooooooooooooooooooooooooooooooong test", "Name " + i));
        }
        public ListModelList getCustomers() {
            return customers;
        }
    }
    ]]></zscript>
        <grid apply="org.zkoss.bind.BindComposer"
              viewModel="@id('vm1') @init('TestVM')"
              height="400px"
              span="false"
              model="@load(vm1.customers)">
            <auxhead>
                <auxheader label="First 3 Columns" colspan="3"/>
                <auxheader label="Next 3 Columns" colspan="3"/>
            </auxhead>
            <columns sizable="true" menupopup="auto">
                <column hflex="min" label="Column 1" sort="auto(name0)"/>
                <column hflex="min" label="Column 2" sort="auto(name1)"/>
                <column hflex="min" label="Column 3" sort="auto(name2)"/>
                <column label="Column 4" sort="auto(name3)"/>
                <column label="Column 5" sort="auto(name4)"/>
                <column label="Column 6" sort="auto(name5)"/>
            </columns>
            <frozen columns="3"/>
            <template name="model">
                <row>
                    <cell>
                        <label value="@load(each.name0)"/>
                    </cell>
                    <cell>
                        <label value="@load(each.name1)"/>
                    </cell>
                    <cell>
                        <label value="@load(each.name2)"/>
                    </cell>
                    <cell>
                        <label value="@load(each.name3)"/>
                    </cell>
                    <cell>
                        <label value="@load(each.name4)"/>
                    </cell>
                    <cell>
                        <label value="@load(each.name5)"/>
                    </cell>
                </row>
            </template>
            <foot>
                <footer/>
                <footer/>
                <footer/>
                <footer label="Footer"/>
                <footer label="Footer"/>
                <footer label="Footer"/>
            </foot>
        </grid>
    </zk>
"""  
  runZTL(zscript,
    () => {
      val grid = jq("@grid")
      val firstColumn = grid.find(".z-column").first
      mouseOver(firstColumn)
      waitResponse()
      val column_button = firstColumn.toWidget.$n("btn")
      click(column_button)
      waitResponse()
      click(jq(".z-menupopup-open .z-menupopup-content .z-menuitem-checkable").get(3))
      waitResponse()
      frozenScroll(grid, 2860)
      waitResponse()
      frozenScroll(grid, -2860)
      verifyEquals(jq("@grid .z-column:first").outerWidth(), jq("@grid .z-rows .z-row:first .z-cell:first").outerWidth())
      verifyEquals(jq("@grid .z-column:eq(1)").outerWidth(), jq("@grid .z-rows .z-row:first .z-cell:eq(1)").outerWidth())
      verifyEquals(jq("@grid .z-column:eq(2)").outerWidth(), jq("@grid .z-rows .z-row:first .z-cell:eq(2)").outerWidth())
      verifyEquals(jq("@grid .z-column:eq(4)").outerWidth(), jq("@grid .z-rows .z-row:first .z-cell:eq(4)").outerWidth())
    })
  }
}