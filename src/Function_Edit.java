public class Function_Edit {
    notepad gui;
    public Function_Edit(notepad gui){
        this.gui = gui;
    }

    public void undo(){
        gui.um.undo();
    }
    public void redo(){
        gui.um.redo();
    }
}
