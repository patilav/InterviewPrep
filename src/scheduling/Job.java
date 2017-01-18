package scheduling;

public class Job {
	private int id, submitTime, cpuTimeLeft;
	private int startTime = 0;
	private int endTime = 0;
	private JobFinishEvent evt;
	private int arrivalTime, cpuTime, processId;
	public int ProcessCompletionTime;
    public int processArrivalTime;
    public int waitingTime;
    public int turnAroundTime;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(int submitTime) {
		this.submitTime = submitTime;
	}

	public int getCpuTimeLeft() {
		return cpuTimeLeft;
	}

	public void setCpuTimeLeft(int cpuTimeLeft) {
		this.cpuTimeLeft = cpuTimeLeft;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	public Job (int id, int submitTime, int cpuTime, JobFinishEvent evt ){
		super();
		this.id = id;
		this.submitTime = submitTime;
		this.cpuTime = cpuTime;
		this.cpuTimeLeft = cpuTime;
		this.evt = evt;
	}
	
	public Job (int processId, int arrivalTime, int cpuTime){
		this.processId = processId;
		this.arrivalTime = arrivalTime;
		this.cpuTime = cpuTime;
	}
	public void start(int sysTime) { 
		this.startTime = sysTime;
	}
	public void tick(int sysTime) {
		cpuTimeLeft --;
		if(cpuTimeLeft<=0){
			endTime = sysTime;
			evt.onFinish(this);
		}
	}
	
}
