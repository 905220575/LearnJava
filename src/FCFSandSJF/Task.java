package FCFSandSJF;

public class Task {

	private int taskID; //任务ID
	private int arrivalTime; //到达时间
	private int serviceTime; //服务时间
	private int startingTime; //开始时间
	private int finishingTime; //完成时间=开始时间+服务时间
	private int turnAroundTime; //周转时间=完成时间-达到时间
	private double weightTurnAround; //带权周转时间=周转时间/服务时间
    private boolean visited = false; 

	public Task(int taskID, int arrivalTime, int serviceTime) {
		// TODO Auto-generated constructor stub
		this.taskID = taskID;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}

	public int getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}

	public int getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	public double getWeightTurnAround() {
		return weightTurnAround;
	}

	public void setWeightTurnAround(double weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

	@Override
	public String toString() {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		return "Task [taskID=" + taskID + ", arrivalTime=" + arrivalTime + ", serviceTime=" + serviceTime
				+ ", startingTime=" + startingTime + ", finishingTime=" + finishingTime + ", turnAroundTime="
				+ turnAroundTime + ", weightTurnAround=" + df.format(weightTurnAround) + "]";
	}
	
}
