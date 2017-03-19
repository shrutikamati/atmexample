/*
 * ATM Example system - file NetworkToBank.java
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
package atm.physical;

import java.net.InetAddress;

import banking.Message;
import banking.Balances;
import banking.Status;
import simulation.Simulation;

/** Manager for the ATM's network connection.  In a real ATM, this would 
 *  manage a physical device; in this simulation,  it uses classes 
 *  in package simulation to simulate the device.
 */
 
public class NetworkToBank
{
    /** Constructor
     *
     *  @param log the log in which to record sending of messages and responses
     *  @param bankAddress the network address of the bank
     */
    public NetworkToBank(InetAddress bankAddress)
    {
        this.bankAddress = bankAddress;
    }
    
    /** Open connection to bank at system startup
     */
    public void openConnection()
    {
        // Since the network is simulated, we don't have to do anything
    }
    
    /** Close connection to bank at system shutdown
     */
    public void closeConnection()
    {
        // Since the network is simulated, we don't have to do anything
    }
    
    /** Send a message to bank
     *
     *  @param message the message to send
     *  @param balances (out) balances in customer's account as reported
     *         by bank
     *  @return status code returned by bank
     */
    public Status sendMessage(Message message, Balances balances)
    {
        // Log sending of the message
        
        //log.logSend(message);
    	Simulation.getInstance().printLogLine("Message:   " + message.toString()); 
        // Simulate the sending of the message - here is where the real code
        // to actually send the message over the network would go
        
        Status result = Simulation.getInstance().sendMessage(message, balances);
        // Log the response gotten back
        
        //log.logResponse(result);
        Simulation.getInstance().printLogLine("Response:  " + result);
        return result;
    }
    
    // Network address of the bank
    
    private InetAddress bankAddress;
}
