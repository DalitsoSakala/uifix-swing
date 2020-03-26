/*
 * @author dalitso sakala https://github.com/dalitsosakala
 *
 */


//
// Layout organisation
//
//
package git.ds.uifixswing
import javax.swing.*
import java.awt.*

/*
**
**
** @param side the border on which the added component should lie (i.e BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH)
** @param item the ui component to add
** @param boxIndex the index of the borderbox in the components hierachy of the parent BoxLayout component
**/
fun JPanel.addToBorder(side:String,item:Component,boxIndex:Int){
		// This represents the JPanel[ layout=BoxLayout ]
		val parentOfBox=(components[0] as JComponent)
		// This represents the JPanel[ layout=BorderLayout ]
		val borderBox=(parentOfBox.components[boxIndex] as JComponent)
		// ensure the component is a  JPanel[ layout=BorderLayout ]
		if(borderBox.layout is BorderLayout){
			borderBox.add(item,side)
		}
}

/**
 *	This extension creates a layout matrix using javas swing BorderLayout
 *	with the slots stacked on top of the other with fixed widths
 *  @param count the number of stacked JPanel[ layout=BorderLayout ]s we want to add items to
 *  @param withSize an attempt to give the main view of the returned JPanel[ FlowLayout ] a preferred size
 *	@param flow the FlowLayout constructor's parameter to determine the alignment of components. By default, the alignment is to the left (FlowLayout.LEADING)
 *  @returns an array with two items. [0] represents the JPanel which wraps the component slots and [1] represents a mapOf<Int,JPanel> for the slots with [ layout=BorderLayout ] to add the components. The value of [0] can be set as the content pane of the JPanel or as a child of another JPanel
 */
fun Container.createStackedSlots(count:Int,withSize:Dimension?=null,flow:Int=FlowLayout.LEADING):Array<Any>{
	val mainBox=JPanel(FlowLayout(flow))
	val subBox=JPanel().apply{layout=BoxLayout(this,BoxLayout.Y_AXIS)}
	val boxes=mutableMapOf<Int,JPanel>()
	if(withSize!=null)
		mainBox.preferredSize=size
	for(index in 0..(count-1))
	{
		subBox.apply{
			val borderBox=JPanel(BorderLayout())
			boxes[index]=borderBox
			add(borderBox)
		}
		
	}
	mainBox.add(subBox)
	return arrayOf(mainBox,boxes)
}

