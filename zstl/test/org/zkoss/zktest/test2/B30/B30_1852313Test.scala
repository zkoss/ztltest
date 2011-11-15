/* B30_1852313Test.scala

{{IS_NOTE
    Purpose:
        
    Description:
        
    History:
        Tue Nov 08 22:51:02 GFT 2011, Created by ldnigro
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

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
 * A test class for bug 1852313
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1852313.zul,A,M,Tree")
class B30_1852313Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk
                xmlns="http://www.zkoss.org/2005/zul"
                xmlns:h="http://www.w3.org/1999/xhtml"
                xmlns:n="http://www.zkoss.org/2005/zk/native">
                <n:h3>Open any Tree node (just once), the browser should NOT have any javascript error!</n:h3>
                <n:h3>If the layout look incorrect, it is a normal result.</n:h3>

                <window>

                    <zscript><![CDATA[

                    int counter = 3;
                    String az = "The quick brown fox jumped over the lazy dog";
                    Random r = new Random();

                    EventListener aa = new EventListener()
                    {
                        public void onEvent(Event event)
                        {
                            autoAdd( event.target );
                        }
                    };

                    void autoAdd(Treeitem parent)
                    {
                        if ( parent.treechildren == null )
                            parent.appendChild( new Treechildren() );

                        if ( !parent.empty )
                            return;

                        for (int i=0; i < 10; i++)
                        {
                            Treeitem ti = new Treeitem();
                            Treerow  tr = new Treerow();
                            String   c  = Integer.toString( ++counter );

                            for ( int x=0 ; x < 4 ; x++ )
                            {
                                switch ( r.nextInt() % 3 )
                                {
                                    case 0: createLabelCell (c).setParent(tr); break;
                                    case 1: createDoubleCell(counter).setParent(tr);
                                    case 2: createLabelCell (az).setParent(tr); break;
                                }
                            }

                            tr.setParent(ti);
                            ti.setOpen(false);
                            ti.appendChild( new Treechildren() );
                            ti.addEventListener( "onOpen", aa );
                            ti.setParent( parent.treechildren );
                        }
                    }

                    Treecell createDoubleCell( Double x )
                    {
                        Treecell tc = new Treecell();
                        tc.appendChild( new Doublebox( x ) );
                        return tc;
                    }
                    Treecell createLabelCell( String x )
                    {
                        Treecell tc = new Treecell();
                        tc.appendChild( new Label( x ) );
                        return tc;
                    }       
                    ]]></zscript>


                    <tree
                        id="tree"
                        rows="30"
                        width="100%"
                        pageSize="-1">
                        <treecols>
                            <treecol label="A" />
                            <treecol label="B" />
                            <treecol label="C" />
                            <treecol label="D" />
                        </treecols>
                        <treechildren>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 1.a" />
                                    <treecell label="Item 1.b" />
                                    <treecell label="Item 1.c" />
                                    <treecell label="Item 1.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 2.a" />
                                    <treecell label="Item 2.b" />
                                    <treecell label="Item 2.c" />
                                    <treecell label="Item 2.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                            <treeitem open="false" onOpen="if (event.open) autoAdd(self)">
                                <treerow>
                                    <treecell label="Item 3.a" />
                                    <treecell label="Item 3.b" />
                                    <treecell label="Item 3.c" />
                                    <treecell label="Item 3.d" />
                                </treerow>
                                <treechildren />
                            </treeitem>
                        </treechildren>
                    </tree>

               </window>
            </zk>
    }

    runZTL(zscript,
        () => {
                
            	val n1=jq("@tree .z-tree-root-close:eq(0)");
            	val n2=jq(".z-tree-tee-close:eq(0)");
            	 
            	//Test item 1
                click(n1);
                waitResponse();
                verifyFalse(jq(".z-error").exists());
                
                //Test subitem 1.4
                click(n2);
                waitResponse();
                verifyFalse(jq(".z-error").exists());
                
                //Test item 2
                click(n1);
                waitResponse();
                verifyFalse(jq(".z-error").exists());
                
                //Test item 3
                click(n1);
                waitResponse();
                verifyFalse(jq(".z-error").exists());
                            
        }
    );
   }
}
