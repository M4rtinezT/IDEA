package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * 	@Description 关于开发团队成员的管理：添加、删除
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月16日下午7:52:24
 *
 */
public class TeamService {
	private static int counter = 1 ;//给memberID赋值
	private final int MAX_MEMBER = 5;//限制开发团队人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
	private int total = 0;//记录开发团队实际人数
	public TeamService() {
		super();
	}
	/**
	 * 	@Description 获取开发团队的所有成员
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午7:58:23
	 *	@return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0 ; i < team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	/**
	 * 	@Description 添加团队成员
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午8:03:17
	 *	@param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
		//成员已满无法添加
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		//该成员不是开发人员
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		//该员工已在开发团队中
		if(isExist(e)) {
			throw new TeamException("该员工已在开发团队中，无法添加");
		}
		Programmer p = (Programmer)e;
		//该员工已是某团队成员
		if(p.getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("该成员是某团队成员，无法添加");
		}else if(p.getStatus().getNAME().equals("VOCATION")) {
			//该员工正在休假，无法添加
			throw new TeamException("该员工正在休假，无法添加");
		}
		//团队中至多只能有一名架构师
		//团队中至多只能有两名设计师
		//团队中至多只能有三名程序员
		int numOfArch = 0;
		int	numOFDes  = 0;
		int numOfPro  = 0;
		for(int i = 0;i < total; i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOFDes++;
			}else {
				numOfPro++;
			}
		}
		if(e instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if (e instanceof Designer) {
			if(numOFDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else {
			if(numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		//讲P添加到现有的team中
		team[total++] = p;
		//开发团队中属性赋值
		p.setStatus(status.BUSY);
		p.setMemberId(counter++);
	}
	
	/**
	 * 	@Description 判断指定员工是否在开发团队中
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午10:10:49
	 *	@param e
	 *	@return
	 */
	private boolean isExist(Employee e) {
		for(int i = 0; i < total ; i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 	@Description 删除指定员工
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午8:03:31
	 *	@param memberId
	 * @throws TeamException 
	 */
	public void removeMember(int memberId) throws TeamException {
		int i ;
		for(i = 0 ; i < total ; i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(status.FREE);
				break;
			}
		}
		//未找到指定memberId
		if(i == total) {
			throw new TeamException("未找到指定员工，删除失败！");
		}
		for (int j = i; j < total - 1; j++) {
			team[j] = team [j+1];
		}
		team[--total] = null;
	}
}
