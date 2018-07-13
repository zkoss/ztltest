/* B50_3000987Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3000987Test extends ZTL4ScalaTestCase {
  @Test
  def testChangeLabel() = {
    var zscript =
      """
<zk>
	<zscript>
		ListModelArray lma = new ListModelArray( new Object[] {"a", "b", "c" } );

		ListitemRenderer lir = new ListitemRenderer() {

                    public void render( Listitem item, java.lang.Object data, int index ) {
                        new Listcell( ( ( String ) data ).toUpperCase()).setParent( item );
                        item.setValue( data );
                    }
                };
	</zscript>
	<listbox id="list" width="200px" mold="select" itemRenderer="${lir}" model="${lma}"  />
	<button label="Klikk!" onClick='list.getChildren().get( 2 ).getChildren().get( 0 ).setLabel( "D" )' />
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("D", jq("@option:eq(2)").text())
    })
  }
}



