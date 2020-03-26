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


fun createVars():JFrame{
	return object:JFrame("UIFix test"){
		init{
			setBounds(100,100,400,300)
			setDefaultCloseOperation(EXIT_ON_CLOSE)
			createUI()
		}
		fun createUI(){
			var contents =createStackedSlots(count=3)
			contentPane=contents[0] as JPanel
			(contentPane as JPanel).apply{
				addToBorder(BorderLayout.EAST,JTextField(10),0)
				addToBorder(BorderLayout.WEST,JLabel("Email").apply{preferredSize=Dimension(100,height)},0)
				addToBorder(BorderLayout.EAST,JTextField(10),1)
				addToBorder(BorderLayout.WEST,JLabel("Email").apply{preferredSize=Dimension(100,height)},1)
				addToBorder(BorderLayout.EAST,JTextField(10),2)
				addToBorder(BorderLayout.WEST,JLabel("Email").apply{preferredSize=Dimension(100,height)},2)
			}
		
		}
	}

}

fun main(args:Array<String>){

	try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
	}catch(e:Exception){}
	var uifixFrame=createVars()
	SwingUtilities.invokeLater{
		uifixFrame.setVisible(true)
	}
}
