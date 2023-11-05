describe('Testing Register Form', () => {
    it('should render the form without crashing', () => {
      cy.visit('http://localhost:5173/register');
      cy.get('[data-testid="register-form"]').should('exist')  
    })

    it("should type form inputs" , () => {
        const today = new Date().toISOString().split('T')[0]
        cy.visit('http://localhost:5173/register');
        cy.get('[data-testid="register-form"]').should('exist')  
        cy.get('[data-testid="first-name"]').type('Somefirstname')  
        cy.get('[data-testid="last-name"]').type('Somelastname')  
        cy.get('[data-testid="password"]').type('Somepassword')  
        cy.get('[data-testid="confirm-password"]').type('Somepassword')  
        cy.get('div').should('exist');
        cy.wait(1000);
        cy.get('[data-testid="controller"]').should('exist')  
        cy.get('[data-testid="role-select"]').select('test')  
        cy.get('[data-testid="birth-date"]').type(today)  
        cy.get('[data-testid="birth-date"]').should('have.value', today)

    })
})