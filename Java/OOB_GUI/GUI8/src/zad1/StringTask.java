package zad1;

public class StringTask implements Runnable{

	private String string;
	private String result;
	private int howManyToDo;
	private Thread thred;
	private static volatile boolean imDone;
	volatile private TaskState state;

	public StringTask(String argString, int i) {
		string = argString;
		result = "";
		howManyToDo = i;
		thred = new Thread (this, "|D4|24|)!53 (!|2((_)5");
		state = TaskState.CREATED;
	}

	public TaskState getState() {
		//		if (thred.isAlive())
		//			return TaskState.RUNNING;
		//		if (!thred.isAlive())
		//			return TaskState.READY;
		//		if (imDone)
		//			return TaskState.ABORTED;
		return state;
	}

	public boolean isDone() {
		return imDone;
	}

	public String getResult() {
		return result;
	}

	@Override
	public void run() {
		try{
			for (int i = 0; i < howManyToDo; i++){
				if (thred.isInterrupted())
					throw new InterruptedException();
				result = result + string;
			}
			imDone = true;
			state = TaskState.READY;
		} catch (InterruptedException ex){
			state = TaskState.ABORTED;
			imDone = true;
			return;
		}

	}

	public void start() {
		thred.start();
		state = TaskState.RUNNING;

	}
	public void abort() {
		thred.interrupt();
		state = TaskState.ABORTED;
	}



}
