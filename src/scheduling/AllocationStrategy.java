package scheduling;

import java.util.ArrayList;
import java.util.List;

public abstract class AllocationStrategy {
	protected List<Job> jobs;
	protected ArrayList <Job> queue;
	public AllocationStrategy(List<Job> jobs){
		this.jobs = jobs;
	}
	public abstract void run();
}
